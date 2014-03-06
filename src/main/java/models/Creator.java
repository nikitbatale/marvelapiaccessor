package models;
import java.util.Arrays;
import java.util.Date;

import com.google.api.client.util.Key;

public class Creator {

	@Key
	public int id;
	
	@Key
	public String firstName;
	
	@Key
	public String lastName;
	
	@Key
	public String middleName;
	
	@Key
	public String suffix;
	
	@Key
	public String fullName;
	
	@Key
	public Date modified;
	
	@Key
	public String resourceURI;
	
	@Key
	public Url[] urls;
	
	@Key
	public Image thumbnail;
	
	@Key
	public ResourceList<Series> series;
	
	@Key
	public ResourceList<Story> stories;
	
	@Key
	public ResourceList<Comic> comics;
	
	@Key
	public ResourceList<Event> events;

	@Override
	public String toString() {
		return "Creator [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", middleName=" + middleName + ", suffix="
				+ suffix + ", fullName=" + fullName + ", modified=" + modified
				+ ", resourceURI=" + resourceURI + ", urls="
				+ Arrays.toString(urls) + ", thumbnail=" + thumbnail
				+ ", series=" + series + ", stories=" + stories + ", comics="
				+ comics + ", events=" + events + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comics == null) ? 0 : comics.hashCode());
		result = prime * result + ((events == null) ? 0 : events.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((middleName == null) ? 0 : middleName.hashCode());
		result = prime * result
				+ ((modified == null) ? 0 : modified.hashCode());
		result = prime * result
				+ ((resourceURI == null) ? 0 : resourceURI.hashCode());
		result = prime * result + ((series == null) ? 0 : series.hashCode());
		result = prime * result + ((stories == null) ? 0 : stories.hashCode());
		result = prime * result + ((suffix == null) ? 0 : suffix.hashCode());
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
		if (!(obj instanceof Creator))
			return false;
		Creator other = (Creator) obj;
		if (comics == null) {
			if (other.comics != null)
				return false;
		} else if (!comics.equals(other.comics))
			return false;
		if (events == null) {
			if (other.events != null)
				return false;
		} else if (!events.equals(other.events))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (middleName == null) {
			if (other.middleName != null)
				return false;
		} else if (!middleName.equals(other.middleName))
			return false;
		if (modified == null) {
			if (other.modified != null)
				return false;
		} else if (!modified.equals(other.modified))
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
		if (suffix == null) {
			if (other.suffix != null)
				return false;
		} else if (!suffix.equals(other.suffix))
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
