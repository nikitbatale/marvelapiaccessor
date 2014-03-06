package util;

import static org.junit.Assert.*;

import org.junit.Test;

import models.Comic;
import models.Character;
import util.UrlBuilder;
import communications.ApiConstants;

public class UrlBuilderTest extends UrlBuilder {

	@Test
	public void testGetUrlFromParameters() {
		String expectedString = "http://gateway.marvel.com/v1/public/characters/48529/comics",
				actualString = UrlBuilder.getUrlFromParameters(ApiConstants.USEABLE_GATEWAY, Comic.class, 48529, Character.class);
		assertEquals(expectedString, actualString);
		
	}

}
