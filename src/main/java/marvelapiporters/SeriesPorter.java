package marvelapiporters;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import util.UrlBuilder;
import models.Comic;
import models.Series;
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

public class SeriesPorter {

	/**
	 * Fetches a particular series by id.
	 * @param id The id of the series.
	 * @param publicKey The public key of the user under whose credentials the series is to be fetched.
	 * @param privateKey The private key of the user under whose credentials the series is to be fetched.
	 * @return The series with the given id. Returns null if an invalid id is provided.
	 */
	public static Series getSeriesById(int id, String publicKey, String privateKey){
		String encodedUrl = UrlBuilder.getUrlFromParameters(ApiConstants.USEABLE_GATEWAY, Series.class, id, null);
		List<Series> seriess = getSeriessByResourceUrl(encodedUrl, publicKey, privateKey);
		if(seriess.size() >= 1) return seriess.get(0); else return null;
	}
	
	/**
	 * Fetches all the series returned by the provided url. 
	 * @param encodedUrl The url required for fetching series.
	 * @param publicKey The public key of the user under whose credentials the series is to be fetched.
	 * @param privateKey The private key of the user under whose credentials the series is to be fetched.
	 * @return The list containing the series fetched.
	 */
	public static List<Series> getSeriessByResourceUrl(String encodedUrl, String publicKey, String privateKey){
		MarvelApiUrl url = new MarvelApiUrl(encodedUrl, publicKey, privateKey);
		HttpRequestFactory requestFactory = HttpRequestFactoryInitializer.getDefaultFactory();
		try {
			HttpRequest request = requestFactory.buildGetRequest(url);
			HttpResponse response = request.execute();
			return Arrays.asList(response.parseAs(SeriesWrapper.class).data.results);
		}
		catch(IOException ioe){
			ioe.printStackTrace();
			return null;
		}
	}
	

	public static List<Series> getSeriesByCreator(int id, String publicKey, String privateKey){
		String encodedUrl = UrlBuilder.getUrlFromParameters(ApiConstants.USEABLE_GATEWAY, Series.class, id, Creator.class);
		return getSeriessByResourceUrl(encodedUrl, publicKey, privateKey);
	}
	
	public static List<Series> getSeriesBySeries(int id, String publicKey, String privateKey){
		String encodedUrl = UrlBuilder.getUrlFromParameters(ApiConstants.USEABLE_GATEWAY, Series.class, id, Series.class);
		return getSeriessByResourceUrl(encodedUrl, publicKey, privateKey);
	}
	
	public static List<Series> getSeriesByComic(int id, String publicKey, String privateKey){
		String encodedUrl = UrlBuilder.getUrlFromParameters(ApiConstants.USEABLE_GATEWAY, Series.class, id, Comic.class);
		return getSeriessByResourceUrl(encodedUrl, publicKey, privateKey);
	}
	
	public static List<Series> getSeriesByCharacter(int id, String publicKey, String privateKey){
		String encodedUrl = UrlBuilder.getUrlFromParameters(ApiConstants.USEABLE_GATEWAY, Series.class, id, Character.class);
		return getSeriessByResourceUrl(encodedUrl, publicKey, privateKey);
	}
	
	public static List<Series> getSeriesByStory(int id, String publicKey, String privateKey){
		String encodedUrl = UrlBuilder.getUrlFromParameters(ApiConstants.USEABLE_GATEWAY, Series.class, id, Story.class);
		return getSeriessByResourceUrl(encodedUrl, publicKey, privateKey);
	}
	
	/**
	 * Wrapper class for Series. This class contains the data fetched by current request and the status of the response.
	 * @author Nikit
	 *
	 */
	public static class SeriesWrapper {
		
		@Key
		public int code;
		
		@Key
		public String status;
		
		@Key
		public String etag;
		
		@Key
		public SeriesData data;
	}
	
	
	
	public static class SeriesData {
		
		@Key
		public int offset;
		
		@Key
		public int limit;
		
		@Key
		public int total;
		
		@Key
		public int count;
		
		@Key
		public Series[] results;

	}
}
