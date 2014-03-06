package models;
import java.util.Arrays;
import java.util.Date;

import com.google.api.client.util.Key;


public class Series {
	@Key
	public int id;
	
	@Key
	public String title;
	
	@Key
	public String description;
	
	@Key
	public String resourceURI;
	
	@Key
	public Url[] urls;
	
	@Key
	public int startYear;
	
	@Key
	public int endYear;
	
	@Key
	public String rating;
	
	@Key
	public Date modified;
	
	@Key
	public Image thumbnail;
	
	@Key
	public ResourceList<Comic> comics;
	
	@Key
	public ResourceList<Story> stories;
	
	@Key
	public ResourceList<Event> events;
	
	@Key
	public ResourceList<Character> characters;
	
	@Key
	public ResourceList<Creator> creators;
	
	@Key
	public Summary<Series> next;
	
	@Key
	public Summary<Series> previous;

	@Override
	public String toString() {
		return "Series [id=" + id + ", title=" + title + ", description="
				+ description + ", resourceURI=" + resourceURI + ", urls="
				+ Arrays.toString(urls) + ", startYear=" + startYear
				+ ", endYear=" + endYear + ", rating=" + rating + ", modified="
				+ modified + ", thumbnail=" + thumbnail + ", comics=" + comics
				+ ", stories=" + stories + ", events=" + events
				+ ", characters=" + characters + ", creators=" + creators
				+ ", next=" + next + ", previous=" + previous + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((characters == null) ? 0 : characters.hashCode());
		result = prime * result + ((comics == null) ? 0 : comics.hashCode());
		result = prime * result
				+ ((creators == null) ? 0 : creators.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + endYear;
		result = prime * result + ((events == null) ? 0 : events.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((modified == null) ? 0 : modified.hashCode());
		result = prime * result + ((next == null) ? 0 : next.hashCode());
		result = prime * result
				+ ((previous == null) ? 0 : previous.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result
				+ ((resourceURI == null) ? 0 : resourceURI.hashCode());
		result = prime * result + startYear;
		result = prime * result + ((stories == null) ? 0 : stories.hashCode());
		result = prime * result
				+ ((thumbnail == null) ? 0 : thumbnail.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + Arrays.hashCode(urls);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Series))
			return false;
		Series other = (Series) obj;
		if (characters == null) {
			if (other.characters != null)
				return false;
		} else if (!characters.equals(other.characters))
			return false;
		if (comics == null) {
			if (other.comics != null)
				return false;
		} else if (!comics.equals(other.comics))
			return false;
		if (creators == null) {
			if (other.creators != null)
				return false;
		} else if (!creators.equals(other.creators))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (endYear != other.endYear)
			return false;
		if (events == null) {
			if (other.events != null)
				return false;
		} else if (!events.equals(other.events))
			return false;
		if (id != other.id)
			return false;
		if (modified == null) {
			if (other.modified != null)
				return false;
		} else if (!modified.equals(other.modified))
			return false;
		if (next == null) {
			if (other.next != null)
				return false;
		} else if (!next.equals(other.next))
			return false;
		if (previous == null) {
			if (other.previous != null)
				return false;
		} else if (!previous.equals(other.previous))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (resourceURI == null) {
			if (other.resourceURI != null)
				return false;
		} else if (!resourceURI.equals(other.resourceURI))
			return false;
		if (startYear != other.startYear)
			return false;
		if (stories == null) {
			if (other.stories != null)
				return false;
		} else if (!stories.equals(other.stories))
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
		if (!Arrays.equals(urls, other.urls))
			return false;
		return true;
	}
}
