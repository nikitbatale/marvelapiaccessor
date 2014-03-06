package marvelapiporters;

import static org.junit.Assert.*;
import models.CharacterSummary;
import models.Comic;
import models.ComicDate;
import models.ComicPrice;
import models.ComicSummary;
import models.CreatorSummary;
import models.EventSummary;
import models.Image;
import models.ResourceList;
import models.SeriesSummary;
import models.StorySummary;
import models.Summary;
import models.TextObject;
import models.Url;

import org.junit.Before;
import org.junit.Test;

public class ComicsPorterTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetComicById() {
		Comic expectedComic = new Comic();
		expectedComic.variantDescription = "";
		expectedComic.description = "";
		expectedComic.isbn = ""; expectedComic.diamondCode = ""; expectedComic.ean = ""; expectedComic.issn = "";
		expectedComic.textObjects = new TextObject[0];
		expectedComic.thumbnail = new Image();
		expectedComic.urls = new Url[1]; expectedComic.urls[0] = new Url();
		expectedComic.series = new SeriesSummary();
		expectedComic.variants = new ComicSummary[0];
		expectedComic.collections = new Summary[0];
		expectedComic.collectedIssues = new Summary[0];
		expectedComic.dates = new ComicDate[2]; expectedComic.dates[0] = new ComicDate(); expectedComic.dates[1] = new ComicDate();
		expectedComic.prices = new ComicPrice[1]; expectedComic.prices[0] = new ComicPrice();
		expectedComic.images = new Image[0];
		expectedComic.creators = new ResourceList<CreatorSummary>(); expectedComic.creators.items = new CreatorSummary[1]; expectedComic.creators.items[0] = new CreatorSummary();
		expectedComic.characters = new ResourceList<CharacterSummary>(); expectedComic.characters.items = new CharacterSummary[0];
		expectedComic.events = new ResourceList<EventSummary>(); expectedComic.events.items = new EventSummary[0];  
		expectedComic.stories = new ResourceList<StorySummary>(); expectedComic.stories.items = new StorySummary[2]; expectedComic.stories.items[0] = new StorySummary(); expectedComic.stories.items[1] = new StorySummary();
		expectedComic.id = 48529; expectedComic.digitalId = 0; expectedComic.title = "All-New X-Men (2012) #26"; expectedComic.issueNumber = 26.0; expectedComic.modified = "2014-02-06T13:44:13-0500"; expectedComic.upc = "75960607900102610"; expectedComic.format = "Comic"; expectedComic.pageCount = 32; expectedComic.resourceURI = "http://gateway.marvel.com/v1/public/comics/48529";
		expectedComic.series.resourceURI = "http://gateway.marvel.com/v1/public/series/16449"; expectedComic.series.name = "All-New X-Men (2012 - Present)";
		expectedComic.dates[0].type = "onsaleDate"; expectedComic.dates[0].date = "2014-04-30T00:00:00-0400";
		expectedComic.dates[1].type = "focDate"; expectedComic.dates[1].date = "2014-04-16T00:00:00-0400";
		expectedComic.urls[0].type = "detail"; expectedComic.urls[0].url = "http://marvel.com/comics/issue/48529/all-new_x-men_2012_26?utm_campaign=apiRef&utm_source=beef288b151b23c4daea634279be8086";
		expectedComic.prices[0].type = "printPrice"; expectedComic.prices[0].price = 3.99f; 
		expectedComic.thumbnail.extension = "jpg"; expectedComic.thumbnail.path = "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available";
		expectedComic.creators.available = 1; expectedComic.creators.returned = 1; expectedComic.creators.collectionURI = "http://gateway.marvel.com/v1/public/comics/48529/creators";
		expectedComic.creators.items[0].name = "Nick Lowe"; expectedComic.creators.items[0].role = "editor"; 
		expectedComic.characters.available = 0; expectedComic.characters.returned = 0; expectedComic.characters.collectionURI = "http://gateway.marvel.com/v1/public/comics/48529/characters";
		expectedComic.stories.available = 2; expectedComic.stories.returned = 2; expectedComic.stories.collectionURI = "http://gateway.marvel.com/v1/public/comics/48529/stories";
		expectedComic.stories.items[0].name = "cover from All-New X-Men (2012) #26"; expectedComic.stories.items[0].type = "cover";
		expectedComic.stories.items[0].resourceURI = "http://gateway.marvel.com/v1/public/stories/109153";
		expectedComic.stories.items[1].name = "story from All-New X-Men (2012) #26"; expectedComic.stories.items[1].type = "interiorStory";
		expectedComic.stories.items[1].resourceURI = "http://gateway.marvel.com/v1/public/stories/109154";
		expectedComic.events.available = 0; expectedComic.events.returned = 0; expectedComic.events.collectionURI = "http://gateway.marvel.com/v1/public/comics/48529/events";
		
		Comic actualComic = ComicsPorter.getComicById(48529, LoginKredentials.PUBLIC_KEY, LoginKredentials.PRIVATE_KEY);
		System.out.println(actualComic);
		System.out.println(expectedComic);
		assertEquals(expectedComic, actualComic);
	}

}
