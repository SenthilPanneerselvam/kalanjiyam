package org.tamil.kalanjiyam.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import com.jayway.jsonpath.JsonPath;

public class HttpUtils {
	
	private static HttpClient client = HttpClientBuilder.create().build();
	//private static final String URL = "https://api.dialogflow.com/v1/query?v=20170712&query={1}&lang=en&sessionId=ce337b9a-23f2-4c67-bf67-798edb75f739&timezone=Asia/Calcutta";
	private static final String URL = "https://api.dialogflow.com/v1/query?v=20170712&query={1}&lang=en&sessionId=772ba832-32e2-45c7-8481-7f793fda3290&timezone=Europe/London";
	private static final String GOOGLE_TRANSLATION = "https://translation.googleapis.com/language/translate/v2?q={1}&target=en&key=AIzaSyBxLpkpp5Jt_DRlsI6dJ4x2Nv5jaFD6vG0";
	
	private static final String USER_AGENT = "Mozilla/5.0 (Linux; <Android Version>; <Build Tag etc.>) AppleWebKit/<WebKit Rev> (KHTML, like Gecko) Chrome/<Chrome Rev> Mobile Safari/<WebKit Rev>";

	public static String callDialogFlow(String requestText) throws ClientProtocolException, IOException {
		String url = URL.replace("{1}",URLEncoder.encode(requestText));
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization", "Bearer b18648df543d49c0a87d67f3ddb908da");
		String json = getJSON(url, headers);
		return JsonPath.read(json, "$.result.fulfillment.messages[0].speech");
	}
	
	public static String callGoogleTranslation(String requestText) throws ClientProtocolException, IOException {
		String url = GOOGLE_TRANSLATION.replace("{1}",URLEncoder.encode(requestText));
		String json = getJSON(url, null);
		return JsonPath.read(json, "$.data.translations[0].translatedText");
	}
	
	public static String getJSON(String url, Map<String, String> headers) throws ClientProtocolException, IOException {
		HttpGet request = new HttpGet(url);

		// add request header
		request.addHeader("User-Agent", USER_AGENT);
		if (headers != null)
			headers.entrySet().forEach(entry -> {
				request.addHeader(entry.getKey(), entry.getValue());
			});
		HttpResponse response = client.execute(request);
		InputStream instream = null;
		StringBuffer result = new StringBuffer();
		try {
			System.out.println("DF Response Code : "
	                + response.getStatusLine().getStatusCode());

			instream = response.getEntity().getContent();
			
			BufferedReader rd = new BufferedReader(
				new InputStreamReader(instream));
		
			
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
		} finally {
			instream.close();
		}
		
		return result.toString();
	}
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		//System.out.println(callGoogleTranslation("உன் வயது என்ன?"));
		System.out.println(callDialogFlow("age?"));
	}
	
}
