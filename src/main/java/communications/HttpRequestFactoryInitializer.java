package communications;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;

public class HttpRequestFactoryInitializer {
	
	private HttpRequestFactoryInitializer(){}

	public static HttpRequestFactory getDefaultFactory(){
		return new NetHttpTransport().createRequestFactory(new HttpRequestInitializer(){
			@Override
			public void initialize(HttpRequest request) {
				request.setParser(new JsonObjectParser(new JacksonFactory()));
			}
		});
	}
}
