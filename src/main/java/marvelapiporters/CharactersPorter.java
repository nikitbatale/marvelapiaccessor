package marvelapiporters;

import java.awt.Event;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import util.UrlBuilder;
import models.Comic;
import models.Character;
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

public class CharactersPorter {

	/**
	 * Fetches a particular character by id.
	 * @param id The id of the character.
	 * @param publicKey The public key of the user under whose credentials the character is to be fetched.
	 * @param privateKey The private key of the user under whose credentials the character is to be fetched.
	 * @return The character with the given id. Returns null if an invalid id is provided.
	 */
	public static Character getCharacterById(int id, String publicKey, String privateKey){
		String encodedUrl = UrlBuilder.getUrlFromParameters(ApiConstants.USEABLE_GATEWAY, Character.class, id, null);
		List<Character> characters = getCharactersByResourceUrl(encodedUrl, publicKey, privateKey);
		if(characters.size() >= 1) return characters.get(0); else return null;
	}
	
	/**
	 * Fetches all the characters returned by the provided url. 
	 * @param encodedUrl The url required for fetching characters.
	 * @param publicKey The public key of the user under whose credentials the character is to be fetched.
	 * @param privateKey The private key of the user under whose credentials the character is to be fetched.
	 * @return The list containing the characters fetched.
	 */
	public static List<Character> getCharactersByResourceUrl(String encodedUrl, String publicKey, String privateKey){
		MarvelApiUrl url = new MarvelApiUrl(encodedUrl, publicKey, privateKey);
		HttpRequestFactory requestFactory = HttpRequestFactoryInitializer.getDefaultFactory();
		try {
			HttpRequest request = requestFactory.buildGetRequest(url);
			HttpResponse response = request.execute();
			return Arrays.asList(response.parseAs(CharacterWrapper.class).data.results);
		}
		catch(IOException ioe){
			ioe.printStackTrace();
			return null;
		}
	}
	

	public static List<Character> getCharactersByCreator(int id, String publicKey, String privateKey){
		String encodedUrl = UrlBuilder.getUrlFromParameters(ApiConstants.USEABLE_GATEWAY, Character.class, id, Creator.class);
		return getCharactersByResourceUrl(encodedUrl, publicKey, privateKey);
	}
	
	public static List<Character> getCharactersBySeries(int id, String publicKey, String privateKey){
		String encodedUrl = UrlBuilder.getUrlFromParameters(ApiConstants.USEABLE_GATEWAY, Character.class, id, Series.class);
		return getCharactersByResourceUrl(encodedUrl, publicKey, privateKey);
	}
	
	public static List<Character> getCharactersByComic(int id, String publicKey, String privateKey){
		String encodedUrl = UrlBuilder.getUrlFromParameters(ApiConstants.USEABLE_GATEWAY, Character.class, id, Comic.class);
		return getCharactersByResourceUrl(encodedUrl, publicKey, privateKey);
	}
	
	public static List<Character> getCharactersByEvent(int id, String publicKey, String privateKey){
		String encodedUrl = UrlBuilder.getUrlFromParameters(ApiConstants.USEABLE_GATEWAY, Character.class, id, Event.class);
		return getCharactersByResourceUrl(encodedUrl, publicKey, privateKey);
	}
	
	public static List<Character> getCharactersByStory(int id, String publicKey, String privateKey){
		String encodedUrl = UrlBuilder.getUrlFromParameters(ApiConstants.USEABLE_GATEWAY, Character.class, id, Story.class);
		return getCharactersByResourceUrl(encodedUrl, publicKey, privateKey);
	}
	
	/**
	 * Wrapper class for Character. This class contains the data fetched by current request and the status of the response.
	 * @author Nikit
	 *
	 */
	public static class CharacterWrapper {
		
		@Key
		public int code;
		
		@Key
		public String status;
		
		@Key
		public String etag;
		
		@Key
		public CharacterData data;
	}
	
	
	
	public static class CharacterData {
		
		@Key
		public int offset;
		
		@Key
		public int limit;
		
		@Key
		public int total;
		
		@Key
		public int count;
		
		@Key
		public Character[] results;

	}
}
