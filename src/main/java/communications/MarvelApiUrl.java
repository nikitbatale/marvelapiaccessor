package communications;

import java.util.Date;
import util.MD5Digest;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.util.Key;

public class MarvelApiUrl extends GenericUrl {

	@Key("ts")
	private long timestamp;

	@Key("hash")
	private String hash;
	
	private Date date;
	
	private String privateKey;

	@Key("apikey")
	public String publicKey = "beef288b151b23c4daea634279be8086";
	
	public MarvelApiUrl(String encodedUrl, String publicKey, String privateKey){
		this(encodedUrl, publicKey, privateKey, new java.util.Date());
	}
	
	
	public MarvelApiUrl(String encodedUrl, String publicKey, String privateKey, Date date){
		super(encodedUrl);
		this.date = date;
		timestamp = date.getTime();
		this.publicKey = publicKey;
		this.privateKey = privateKey;
		hash = MD5Digest.getMD5Hash(timestamp + privateKey + publicKey);
	}

	
}
