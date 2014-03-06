package util;

import models.Comic;
import models.Creator;
import models.Event;
import models.Series;
import models.Story;
import models.Character;

public class UrlBuilder {

	/**
	 * Constructs and appends the portion of url pertaining to filters to be applied and items to be fetched from the Marvel Comics gateway.
	 * 
	 * e.g. a call to the method like <code>getUrlFromParameters("http://gateway.marvel.com/v1/public/", Character.class, 48529, Comic.class)</code> will fetch "
	 * @param itemFetched The item(s) to be fetched by this Http call to the Marvel api.
	 * @param idProvided The id of the item to be filtered against. The item that will be fetched will be against this filtering. If no id is specified, a minimum no.of items will be fetched. 
	 * @param itemFetchedAgainst The filter item against which the original item is to be fetched. If this parameter is specified as <code>null</code>, id will be used to filter against the item to be fetched.
	 * @return
	 */
	public static String getUrlFromParameters(String baseUrl, Class<?> itemFetched, int idProvided, Class<?> itemFetchedAgainst){
		String filterAgainst = "", id = "", appendage = "";
		if(itemFetched != null) appendage = "/" + getStringForClassType(itemFetched); else return baseUrl;
		if(idProvided == 0) return baseUrl + appendage;
		id = Integer.toString(idProvided);
		if(itemFetchedAgainst != null){
			filterAgainst = getStringForClassType(itemFetchedAgainst);
			appendage = "/" + filterAgainst + "/" + id + appendage;
		} else appendage = appendage + "/" + id;
		if(baseUrl.charAt(baseUrl.length() - 1) == '/') appendage = appendage.substring(1);
		return baseUrl + appendage;
	}
	
	private static String getStringForClassType(Class<?> classType){
		if(classType.equals(Comic.class)) return "comics";
		else if(classType.equals(Character.class)) return "characters";
		else if(classType.equals(Creator.class)) return "creators";
		else if(classType.equals(Story.class)) return "stories";
		else if(classType.equals(Event.class)) return "events";
		else if(classType.equals(Series.class)) return "series";
		return null;
	}
}
