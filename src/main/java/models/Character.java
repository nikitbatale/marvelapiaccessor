package models;
import java.util.Arrays;
import java.util.Date;

import com.google.api.client.util.Key;

public class Character {

	@Key
	public int id;
	
	@Key
	public String name;
	
	@Key
	public String description;
	
	@Key
	public Date modified;
	
	@Key
	public String resourceURI;
	
	@Key
	public Url[] urls;
	
	@Key
	public Image thumbnail;
	
	@Key
	public ResourceList<Comic> comics;
	
	@Key
	public ResourceList<Story> stories;
	
	@Key
	public ResourceList<Event> events;
	
	@Key
	public ResourceList<Series> series;

	@Override
	public String toString() {
		return "Character [id=" + id + ", name=" + name + ", description="
				+ description + ", modified=" + modified + ", resourceURI="
				+ resourceURI + ", urls=" + Arrays.toString(urls)
				+ ", thumbnail=" + thumbnail + ", comics=" + comics
				+ ", stories=" + stories + ", events=" + events + ", series="
				+ series + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comics == null) ? 0 : comics.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((events == null) ? 0 : events.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((modified == null) ? 0 : modified.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((resourceURI == null) ? 0 : resourceURI.hashCode());
		result = prime * result + ((series == null) ? 0 : series.hashCode());
		result = prime * result + ((stories == null) ? 0 : stories.hashCode());
		result = prime * result
				+ ((thumbnail == null) ? 0 : thumbnail.hashCode());
		result = prime * result + Arrays.hashCode(urls);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Character))
			return false;
		Character other = (Character) obj;
		if (comics == null) {
			if (other.comics != null)
				return false;
		} else if (!comics.equals(other.comics))
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
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
		if (thumbnail == null) {
			if (other.thumbnail != null)
				return false;
		} else if (!thumbnail.equals(other.thumbnail))
			return false;
		if (!Arrays.equals(urls, other.urls))
			return false;
		return true;
	}
	
}
