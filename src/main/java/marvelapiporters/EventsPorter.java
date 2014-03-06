package marvelapiporters;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import util.UrlBuilder;
import models.Comic;
import models.Event;
import models.Character;
import models.Creator;
import models.Series;
import models.Story;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.util.Key;

import communications.ApiConstants;
import communications.HttpRequestFactoryInitializer;
import communications.MarvelApiUrl;

public class EventsPorter {

	/**
	 * Fetches a particular event by id.
	 * @param id The id of the event.
	 * @param publicKey The public key of the user under whose credentials the event is to be fetched.
	 * @param privateKey The private key of the user under whose credentials the event is to be fetched.
	 * @return The event with the given id. Returns null if an invalid id is provided.
	 */
	public static Event getEventById(int id, String publicKey, String privateKey){
		String encodedUrl = UrlBuilder.getUrlFromParameters(ApiConstants.USEABLE_GATEWAY, Event.class, id, null);
		List<Event> events = getEventsByResourceUrl(encodedUrl, publicKey, privateKey);
		if(events.size() >= 1) return events.get(0); else return null;
	}
	
	/**
	 * Fetches all the events returned by the provided url. 
	 * @param encodedUrl The url required for fetching events.
	 * @param publicKey The public key of the user under whose credentials the event is to be fetched.
	 * @param privateKey The private key of the user under whose credentials the event is to be fetched.
	 * @return The list containing the events fetched.
	 */
	public static List<Event> getEventsByResourceUrl(String encodedUrl, String publicKey, String privateKey){
		MarvelApiUrl url = new MarvelApiUrl(encodedUrl, publicKey, privateKey);
		HttpRequestFactory requestFactory = HttpRequestFactoryInitializer.getDefaultFactory();
		try {
			HttpRequest request = requestFactory.buildGetRequest(url);
			HttpResponse response = request.execute();
			return Arrays.asList(response.parseAs(EventWrapper.class).data.results);
		}
		catch(IOException ioe){
			ioe.printStackTrace();
			return null;
		}
	}
	

	public static List<Event> getEventsByCreator(int id, String publicKey, String privateKey){
		String encodedUrl = UrlBuilder.getUrlFromParameters(ApiConstants.USEABLE_GATEWAY, Event.class, id, Creator.class);
		return getEventsByResourceUrl(encodedUrl, publicKey, privateKey);
	}
	
	public static List<Event> getEventsBySeries(int id, String publicKey, String privateKey){
		String encodedUrl = UrlBuilder.getUrlFromParameters(ApiConstants.USEABLE_GATEWAY, Event.class, id, Series.class);
		return getEventsByResourceUrl(encodedUrl, publicKey, privateKey);
	}
	
	public static List<Event> getEventsByComic(int id, String publicKey, String privateKey){
		String encodedUrl = UrlBuilder.getUrlFromParameters(ApiConstants.USEABLE_GATEWAY, Event.class, id, Comic.class);
		return getEventsByResourceUrl(encodedUrl, publicKey, privateKey);
	}
	
	public static List<Event> getEventsByCharacter(int id, String publicKey, String privateKey){
		String encodedUrl = UrlBuilder.getUrlFromParameters(ApiConstants.USEABLE_GATEWAY, Event.class, id, Character.class);
		return getEventsByResourceUrl(encodedUrl, publicKey, privateKey);
	}
	
	public static List<Event> getEventsByStory(int id, String publicKey, String privateKey){
		String encodedUrl = UrlBuilder.getUrlFromParameters(ApiConstants.USEABLE_GATEWAY, Event.class, id, Story.class);
		return getEventsByResourceUrl(encodedUrl, publicKey, privateKey);
	}
	
	/**
	 * Wrapper class for Event. This class contains the data fetched by current request and the status of the response.
	 * @author Nikit
	 *
	 */
	public static class EventWrapper {
		
		@Key
		public int code;
		
		@Key
		public String status;
		
		@Key
		public String etag;
		
		@Key
		public EventData data;
	}
	
	
	
	public static class EventData {
		
		@Key
		public int offset;
		
		@Key
		public int limit;
		
		@Key
		public int total;
		
		@Key
		public int count;
		
		@Key
		public Event[] results;

	}
}
