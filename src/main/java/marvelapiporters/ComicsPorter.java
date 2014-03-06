package marvelapiporters;

import java.awt.Event;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.util.Key;

import util.UrlBuilder;
import communications.HttpRequestFactoryInitializer;
import communications.MarvelApiUrl;
import communications.ApiConstants;
import models.Comic;
import models.Creator;
import models.Series;
import models.Story;

public class ComicsPorter {
	
	/**
	 * Fetches a particular comic by id.
	 * @param id The id of the comic.
	 * @param publicKey The public key of the user under whose credentials the comic is to be fetched.
	 * @param privateKey The private key of the user under whose credentials the comic is to be fetched.
	 * @return The comic with the given id. Returns null if an invalid id is provided.
	 */
	public static Comic getComicById(int id, String publicKey, String privateKey){
		String encodedUrl = UrlBuilder.getUrlFromParameters(ApiConstants.USEABLE_GATEWAY, Comic.class, id, null);
		List<Comic> comics = getComicsByResourceUrl(encodedUrl, publicKey, privateKey);
		if(comics.size() >= 1) return comics.get(0); else return null;
	}
	
	
	/**
	 * Fetches all the comics returned by the provided url. 
	 * @param encodedUrl The url required for fetching comics.
	 * @param publicKey The public key of the user under whose credentials the comic is to be fetched.
	 * @param privateKey The private key of the user under whose credentials the comic is to be fetched.
	 * @return The list containing the comics fetched.
	 */
	public static List<Comic> getComicsByResourceUrl(String encodedUrl, String publicKey, String privateKey){
		MarvelApiUrl url = new MarvelApiUrl(encodedUrl, publicKey, privateKey);
		HttpRequestFactory requestFactory = HttpRequestFactoryInitializer.getDefaultFactory();
		try {
			HttpRequest request = requestFactory.buildGetRequest(url);
			HttpResponse response = request.execute();
			return Arrays.asList(response.parseAs(ComicWrapper.class).data.results);
		}
		catch(IOException ioe){
			ioe.printStackTrace();
			return null;
		}
	}

	
	public static List<Comic> getComicsByCharacter(int id, String publicKey, String privateKey){
		String encodedUrl = UrlBuilder.getUrlFromParameters(ApiConstants.USEABLE_GATEWAY, Comic.class, id, Character.class);
		return getComicsByResourceUrl(encodedUrl, publicKey, privateKey);
	}
	
	public static List<Comic> getComicsBySeries(int id, String publicKey, String privateKey){
		String encodedUrl = UrlBuilder.getUrlFromParameters(ApiConstants.USEABLE_GATEWAY, Comic.class, id, Series.class);
		return getComicsByResourceUrl(encodedUrl, publicKey, privateKey);
	}
	
	public static List<Comic> getComicsByCreator(int id, String publicKey, String privateKey){
		String encodedUrl = UrlBuilder.getUrlFromParameters(ApiConstants.USEABLE_GATEWAY, Comic.class, id, Creator.class);
		return getComicsByResourceUrl(encodedUrl, publicKey, privateKey);
	}
	
	public static List<Comic> getComicsByEvent(int id, String publicKey, String privateKey){
		String encodedUrl = UrlBuilder.getUrlFromParameters(ApiConstants.USEABLE_GATEWAY, Comic.class, id, Event.class);
		return getComicsByResourceUrl(encodedUrl, publicKey, privateKey);
	}
	
	public static List<Comic> getComicsByStory(int id, String publicKey, String privateKey){
		String encodedUrl = UrlBuilder.getUrlFromParameters(ApiConstants.USEABLE_GATEWAY, Comic.class, id, Story.class);
		return getComicsByResourceUrl(encodedUrl, publicKey, privateKey);
	}
	/**
	 * Wrapper class for Comic. This class contains the data fetched by current request and the status of the response.
	 * @author Nikit
	 *
	 */
	public static class ComicWrapper {
		
		@Key
		public int code;
		
		@Key
		public String status;
		
		@Key
		public String etag;
		
		@Key
		public ComicData data;
	}
	
	
	
	public static class ComicData {
		
		@Key
		public int offset;
		
		@Key
		public int limit;
		
		@Key
		public int total;
		
		@Key
		public int count;
		
		@Key
		public Comic[] results;

	}
}
