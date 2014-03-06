package models;
import java.util.Arrays;

import com.google.api.client.util.Key;


public class ResourceList<T> {
	
	@Key
	public int available;
	
	@Key
	public int returned;
	
	@Key
	public String collectionURI;
	
	@Key
	public T[] items;

	@Override
	public String toString() {
		return "ResourceList [available=" + available + ", returned="
				+ returned + ", collectionURI=" + collectionURI + ", items="
				+ Arrays.toString(items) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + available;
		result = prime * result
				+ ((collectionURI == null) ? 0 : collectionURI.hashCode());
		result = prime * result + Arrays.hashCode(items);
		result = prime * result + returned;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ResourceList))
			return false;
		ResourceList other = (ResourceList) obj;
		if (available != other.available)
			return false;
		if (collectionURI == null) {
			if (other.collectionURI != null)
				return false;
		} else if (!collectionURI.equals(other.collectionURI))
			return false;
		if (!Arrays.equals(items, other.items))
			return false;
		if (returned != other.returned)
			return false;
		return true;
	}

}
