package marvelapiporters;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import util.UrlBuilder;
import models.Comic;
import models.Character;
import models.Creator;
import models.Series;
import models.Event;
import models.Story;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.util.Key;

import communications.ApiConstants;
import communications.HttpRequestFactoryInitializer;
import communications.MarvelApiUrl;

public class StoriesPorter {

	/**
	 * Fetches a particular story by id.
	 * @param id The id of the story.
	 * @param publicKey The public key of the user under whose credentials the story is to be fetched.
	 * @param privateKey The private key of the user under whose credentials the story is to be fetched.
	 * @return The story with the given id. Returns null if an invalid id is provided.
	 */
	public static Story getStoryById(int id, String publicKey, String privateKey){
		String encodedUrl = UrlBuilder.getUrlFromParameters(ApiConstants.USEABLE_GATEWAY, Story.class, id, null);
		List<Story> stories = getStorysByResourceUrl(encodedUrl, publicKey, privateKey);
		if(stories.size() >= 1) return stories.get(0); else return null;
	}
	
	/**
	 * Fetches all the stories returned by the provided url. 
	 * @param encodedUrl The url required for fetching stories.
	 * @param publicKey The public key of the user under whose credentials the story is to be fetched.
	 * @param privateKey The private key of the user under whose credentials the story is to be fetched.
	 * @return The list containing the stories fetched.
	 */
	public static List<Story> getStorysByResourceUrl(String encodedUrl, String publicKey, String privateKey){
		MarvelApiUrl url = new MarvelApiUrl(encodedUrl, publicKey, privateKey);
		HttpRequestFactory requestFactory = HttpRequestFactoryInitializer.getDefaultFactory();
		try {
			HttpRequest request = requestFactory.buildGetRequest(url);
			HttpResponse response = request.execute();
			return Arrays.asList(response.parseAs(StoryWrapper.class).data.results);
		}
		catch(IOException ioe){
			ioe.printStackTrace();
			return null;
		}
	}
	

	public static List<Story> getStoriesByCreator(int id, String publicKey, String privateKey){
		String encodedUrl = UrlBuilder.getUrlFromParameters(ApiConstants.USEABLE_GATEWAY, Story.class, id, Creator.class);
		return getStorysByResourceUrl(encodedUrl, publicKey, privateKey);
	}
	
	public static List<Story> getStoriesBySeries(int id, String publicKey, String privateKey){
		String encodedUrl = UrlBuilder.getUrlFromParameters(ApiConstants.USEABLE_GATEWAY, Story.class, id, Series.class);
		return getStorysByResourceUrl(encodedUrl, publicKey, privateKey);
	}
	
	public static List<Story> getStoriesByComic(int id, String publicKey, String privateKey){
		String encodedUrl = UrlBuilder.getUrlFromParameters(ApiConstants.USEABLE_GATEWAY, Story.class, id, Comic.class);
		return getStorysByResourceUrl(encodedUrl, publicKey, privateKey);
	}
	
	public static List<Story> getStoriesByCharacter(int id, String publicKey, String privateKey){
		String encodedUrl = UrlBuilder.getUrlFromParameters(ApiConstants.USEABLE_GATEWAY, Story.class, id, Character.class);
		return getStorysByResourceUrl(encodedUrl, publicKey, privateKey);
	}
	
	public static List<Story> getStoriesByEvent(int id, String publicKey, String privateKey){
		String encodedUrl = UrlBuilder.getUrlFromParameters(ApiConstants.USEABLE_GATEWAY, Story.class, id, Event.class);
		return getStorysByResourceUrl(encodedUrl, publicKey, privateKey);
	}
	
	/**
	 * Wrapper class for Story. This class contains the data fetched by current request and the status of the response.
	 * @author Nikit
	 *
	 */
	public static class StoryWrapper {
		
		@Key
		public int code;
		
		@Key
		public String status;
		
		@Key
		public String etag;
		
		@Key
		public StoryData data;
	}
	
	
	
	public static class StoryData {
		
		@Key
		public int offset;
		
		@Key
		public int limit;
		
		@Key
		public int total;
		
		@Key
		public int count;
		
		@Key
		public Story[] results;

	}
}
