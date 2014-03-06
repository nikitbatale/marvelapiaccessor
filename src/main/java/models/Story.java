package models;
import java.util.Date;

import com.google.api.client.util.Key;


public class Story {
	@Key
	public int id;
	
	@Key
	public String title;
	
	@Key
	public String description;
	
	@Key
	public String resourceURI;
	
	@Key
	public Date modified;
	
	@Key
	public Image thumbnail;
	
	@Key
	public ResourceList<Comic> comics;
	
	@Key
	public ResourceList<Series> series;
	
	@Key
	public ResourceList<Event> events;
	
	@Key
	public ResourceList<Character> characters;
	
	@Key
	public ResourceList<Creator> creators;
	
	@Key
	public Summary<Comic> originalIssue;

	@Override
	public String toString() {
		return "Story [id=" + id + ", title=" + title + ", description="
				+ description + ", resourceURI=" + resourceURI + ", modified="
				+ modified + ", thumbnail=" + thumbnail + ", comics=" + comics
				+ ", series=" + series + ", events=" + events + ", characters="
				+ characters + ", creators=" + creators + ", originalIssue="
				+ originalIssue + "]";
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
		result = prime * result + ((events == null) ? 0 : events.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((modified == null) ? 0 : modified.hashCode());
		result = prime * result
				+ ((originalIssue == null) ? 0 : originalIssue.hashCode());
		result = prime * result
				+ ((resourceURI == null) ? 0 : resourceURI.hashCode());
		result = prime * result + ((series == null) ? 0 : series.hashCode());
		result = prime * result
				+ ((thumbnail == null) ? 0 : thumbnail.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Story))
			return false;
		Story other = (Story) obj;
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
		if (originalIssue == null) {
			if (other.originalIssue != null)
				return false;
		} else if (!originalIssue.equals(other.originalIssue))
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
		return true;
	}
}
