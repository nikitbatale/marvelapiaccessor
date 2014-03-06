package marvelapiporters;

import java.awt.Event;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import util.UrlBuilder;
import models.Comic;
import models.Creator;
import models.Character;
import models.Series;
import models.Story;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.util.Key;

import communications.ApiConstants;
import communications.HttpRequestFactoryInitializer;
import communications.MarvelApiUrl;

public class CreatorsPorter {

	/**
	 * Fetches a particular creator by id.
	 * @param id The id of the creator.
	 * @param publicKey The public key of the user under whose credentials the creator is to be fetched.
	 * @param privateKey The private key of the user under whose credentials the creator is to be fetched.
	 * @return The creator with the given id. Returns null if an invalid id is provided.
	 */
	public static Creator getCreatorById(int id, String publicKey, String privateKey){
		String encodedUrl = UrlBuilder.getUrlFromParameters(ApiConstants.USEABLE_GATEWAY, Creator.class, id, null);
		List<Creator> creators = getCreatorsByResourceUrl(encodedUrl, publicKey, privateKey);
		if(creators.size() >= 1) return creators.get(0); else return null;
	}
	
	/**
	 * Fetches all the creators returned by the provided url. 
	 * @param encodedUrl The url required for fetching creators.
	 * @param publicKey The public key of the user under whose credentials the creator is to be fetched.
	 * @param privateKey The private key of the user under whose credentials the creator is to be fetched.
	 * @return The list containing the creators fetched.
	 */
	public static List<Creator> getCreatorsByResourceUrl(String encodedUrl, String publicKey, String privateKey){
		MarvelApiUrl url = new MarvelApiUrl(encodedUrl, publicKey, privateKey);
		HttpRequestFactory requestFactory = HttpRequestFactoryInitializer.getDefaultFactory();
		try {
			HttpRequest request = requestFactory.buildGetRequest(url);
			HttpResponse response = request.execute();
			return Arrays.asList(response.parseAs(CreatorWrapper.class).data.results);
		}
		catch(IOException ioe){
			ioe.printStackTrace();
			return null;
		}
	}
	

	public static List<Creator> getCreatorsByCharacter(int id, String publicKey, String privateKey){
		String encodedUrl = UrlBuilder.getUrlFromParameters(ApiConstants.USEABLE_GATEWAY, Creator.class, id, Character.class);
		return getCreatorsByResourceUrl(encodedUrl, publicKey, privateKey);
	}
	
	public static List<Creator> getCreatorsBySeries(int id, String publicKey, String privateKey){
		String encodedUrl = UrlBuilder.getUrlFromParameters(ApiConstants.USEABLE_GATEWAY, Creator.class, id, Series.class);
		return getCreatorsByResourceUrl(encodedUrl, publicKey, privateKey);
	}
	
	public static List<Creator> getCreatorsByComic(int id, String publicKey, String privateKey){
		String encodedUrl = UrlBuilder.getUrlFromParameters(ApiConstants.USEABLE_GATEWAY, Creator.class, id, Comic.class);
		return getCreatorsByResourceUrl(encodedUrl, publicKey, privateKey);
	}
	
	public static List<Creator> getCreatorsByEvent(int id, String publicKey, String privateKey){
		String encodedUrl = UrlBuilder.getUrlFromParameters(ApiConstants.USEABLE_GATEWAY, Creator.class, id, Event.class);
		return getCreatorsByResourceUrl(encodedUrl, publicKey, privateKey);
	}
	
	public static List<Creator> getCreatorsByStory(int id, String publicKey, String privateKey){
		String encodedUrl = UrlBuilder.getUrlFromParameters(ApiConstants.USEABLE_GATEWAY, Creator.class, id, Story.class);
		return getCreatorsByResourceUrl(encodedUrl, publicKey, privateKey);
	}
	
	/**
	 * Wrapper class for Creator. This class contains the data fetched by current request and the status of the response.
	 * @author Nikit
	 *
	 */
	public static class CreatorWrapper {
		
		@Key
		public int code;
		
		@Key
		public String status;
		
		@Key
		public String etag;
		
		@Key
		public CreatorData data;
	}
	
	
	
	public static class CreatorData {
		
		@Key
		public int offset;
		
		@Key
		public int limit;
		
		@Key
		public int total;
		
		@Key
		public int count;
		
		@Key
		public Creator[] results;

	}
}
