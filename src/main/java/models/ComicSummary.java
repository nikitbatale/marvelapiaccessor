package models;
import com.google.api.client.util.Key;


public class ComicSummary {
	
	@Key
	public String resourceURI;
	
	@Key
	public String name;

	@Override
	public String toString() {
		return "ComicSummary [resourceURI=" + resourceURI + ", name=" + name
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((resourceURI == null) ? 0 : resourceURI.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ComicSummary))
			return false;
		ComicSummary other = (ComicSummary) obj;
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
		return true;
	}
}
