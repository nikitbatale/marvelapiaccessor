package models;
import java.util.Arrays;

import com.google.api.client.util.Key;


public class Comic {
	
	@Key("id")
	public int id;
	
	@Key("digitalId")
	public int digitalId;
	
	@Key("title")
	public String title;
	
	@Key("issueNumber")
	public double issueNumber;
	
	@Key("variantDescription")
	public String variantDescription;
	
	@Key("description")
	public String description;
	
	@Key("modified")
	public String modified;
	
	@Key("isbn")
	public String isbn;
	
	@Key("upc")
	public Object upc;
	
	@Key("diamondCode")
	public String diamondCode;
	
	@Key("ean")
	public String ean;
	
	@Key("issn")
	public String issn;
	
	@Key("format")
	public String format;
	
	@Key("pageCount")
	public int pageCount;
	
	@Key("textObjects")
	public TextObject[] textObjects;
	
	@Key("resourceURI")
	public String resourceURI;
	
	@Key("urls")
	public Url[] urls;
	
	@Key("series")
	public SeriesSummary series;
	
	@Key("variants")
	public ComicSummary[] variants;
	
	@Key("collections")
	public Summary<Comic>[] collections;
	
	@Key("collectedIssues")
	public Summary<Comic>[] collectedIssues;
	
	@Key("dates")
	public ComicDate[] dates;
	
	@Key("prices")
	public ComicPrice[] prices;
	
	@Key("thumbnail")
	public Image thumbnail;
	
	@Key("images")
	public Image[] images;
	
	@Key("creators")
	public ResourceList<CreatorSummary> creators;
	
	@Key("characters")
	public ResourceList<CharacterSummary> characters;
	
	@Key("stories")
	public ResourceList<StorySummary> stories;
	
	@Key("events")
	public ResourceList<EventSummary> events;

	@Override
	public String toString() {
		return "Comic [id=" + id + ", digitalId=" + digitalId + ", title="
				+ title + ", issueNumber=" + issueNumber
				+ ", variantDescription=" + variantDescription
				+ ", description=" + description + ", modified=" + modified
				+ ", isbn=" + isbn + ", upc=" + upc + ", diamondCode="
				+ diamondCode + ", ean=" + ean + ", issn=" + issn + ", format="
				+ format + ", pageCount=" + pageCount + ", textObjects="
				+ Arrays.toString(textObjects) + ", resourceURI=" + resourceURI
				+ ", urls=" + Arrays.toString(urls) + ", series=" + series
				+ ", variants=" + Arrays.toString(variants) + ", collections="
				+ Arrays.toString(collections) + ", collectedIssues="
				+ Arrays.toString(collectedIssues) + ", dates="
				+ Arrays.toString(dates) + ", prices="
				+ Arrays.toString(prices) + ", thumbnail=" + thumbnail
				+ ", images=" + Arrays.toString(images) + ", creators="
				+ creators + ", characters=" + characters + ", stories="
				+ stories + ", events=" + events + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((characters == null) ? 0 : characters.hashCode());
		result = prime * result + Arrays.hashCode(collectedIssues);
		result = prime * result + Arrays.hashCode(collections);
		result = prime * result
				+ ((creators == null) ? 0 : creators.hashCode());
		result = prime * result + Arrays.hashCode(dates);
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((diamondCode == null) ? 0 : diamondCode.hashCode());
		result = prime * result + digitalId;
		result = prime * result + ((ean == null) ? 0 : ean.hashCode());
		result = prime * result + ((events == null) ? 0 : events.hashCode());
		result = prime * result + ((format == null) ? 0 : format.hashCode());
		result = prime * result + id;
		result = prime * result + Arrays.hashCode(images);
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((issn == null) ? 0 : issn.hashCode());
		long temp;
		temp = Double.doubleToLongBits(issueNumber);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((modified == null) ? 0 : modified.hashCode());
		result = prime * result + pageCount;
		result = prime * result + Arrays.hashCode(prices);
		result = prime * result
				+ ((resourceURI == null) ? 0 : resourceURI.hashCode());
		result = prime * result + ((series == null) ? 0 : series.hashCode());
		result = prime * result + ((stories == null) ? 0 : stories.hashCode());
		result = prime * result + Arrays.hashCode(textObjects);
		result = prime * result
				+ ((thumbnail == null) ? 0 : thumbnail.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((upc == null) ? 0 : upc.hashCode());
		result = prime * result + Arrays.hashCode(urls);
		result = prime
				* result
				+ ((variantDescription == null) ? 0 : variantDescription
						.hashCode());
		result = prime * result + Arrays.hashCode(variants);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Comic))
			return false;
		Comic other = (Comic) obj;
		if (characters == null) {
			if (other.characters != null)
				return false;
		} else if (!characters.equals(other.characters))
			return false;
		if (!Arrays.equals(collectedIssues, other.collectedIssues))
			return false;
		if (!Arrays.equals(collections, other.collections))
			return false;
		if (creators == null) {
			if (other.creators != null)
				return false;
		} else if (!creators.equals(other.creators))
			return false;
		if (!Arrays.equals(dates, other.dates))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (diamondCode == null) {
			if (other.diamondCode != null)
				return false;
		} else if (!diamondCode.equals(other.diamondCode))
			return false;
		if (digitalId != other.digitalId)
			return false;
		if (ean == null) {
			if (other.ean != null)
				return false;
		} else if (!ean.equals(other.ean))
			return false;
		if (events == null) {
			if (other.events != null)
				return false;
		} else if (!events.equals(other.events))
			return false;
		if (format == null) {
			if (other.format != null)
				return false;
		} else if (!format.equals(other.format))
			return false;
		if (id != other.id)
			return false;
		if (!Arrays.equals(images, other.images))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (issn == null) {
			if (other.issn != null)
				return false;
		} else if (!issn.equals(other.issn))
			return false;
		if (Double.doubleToLongBits(issueNumber) != Double
				.doubleToLongBits(other.issueNumber))
			return false;
		if (modified == null) {
			if (other.modified != null)
				return false;
		} else if (!modified.equals(other.modified))
			return false;
		if (pageCount != other.pageCount)
			return false;
		if (!Arrays.equals(prices, other.prices))
			return false;
		if (resourceURI == null) {
			if (other.resourceURI != null)
				return false;
		} else if (!resourceURI.equals(other.resourceURI))
			return false;
		if (series == null) {
			if (other.series != null)
				return false;
		} else if (!series.equals(other.series))
			return false;
		if (stories == null) {
			if (other.stories != null)
				return false;
		} else if (!stories.equals(other.stories))
			return false;
		if (!Arrays.equals(textObjects, other.textObjects))
			return false;
		if (thumbnail == null) {
			if (other.thumbnail != null)
				return false;
		} else if (!thumbnail.equals(other.thumbnail))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (upc == null) {
			if (other.upc != null)
				return false;
		} else if (!upc.equals(other.upc))
			return false;
		if (!Arrays.equals(urls, other.urls))
			return false;
		if (variantDescription == null) {
			if (other.variantDescription != null)
				return false;
		} else if (!variantDescription.equals(other.variantDescription))
			return false;
		if (!Arrays.equals(variants, other.variants))
			return false;
		return true;
	}
	
}
