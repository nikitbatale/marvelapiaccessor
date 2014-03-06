package models;
import com.google.api.client.util.Key;


public class CreatorSummary {

	@Key
	public String resourceURL;
	
	@Key
	public String name;
	
	@Key
	public String role;

	@Override
	public String toString() {
		return "CreatorSummary [resourceURL=" + resourceURL + ", name=" + name
				+ ", role=" + role + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((resourceURL == null) ? 0 : resourceURL.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof CreatorSummary))
			return false;
		CreatorSummary other = (CreatorSummary) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (resourceURL == null) {
			if (other.resourceURL != null)
				return false;
		} else if (!resourceURL.equals(other.resourceURL))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}
}
