package org.tamil.kalanjiyam.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

public class HttpUtils {
	
	private static HttpClient client = HttpClientBuilder.create().build();
	//private static final String URL = "https://api.dialogflow.com/v1/query?v=20170712&query={1}&lang=en&sessionId=ce337b9a-23f2-4c67-bf67-798edb75f739&timezone=Asia/Calcutta";
	private static final String URL = "https://api.dialogflow.com/v1/query?v=20170712&query={1}&lang=en&sessionId=772ba832-32e2-45c7-8481-7f793fda3290&timezone=Europe/London";
	private static final String GOOGLE_TRANSLATION = "https://translation.googleapis.com/language/translate/v2?q={1}&target=en&key=AIzaSyBxLpkpp5Jt_DRlsI6dJ4x2Nv5jaFD6vG0";
	
	private static final String USER_AGENT = "Mozilla/5.0 (Linux; <Android Version>; <Build Tag etc.>) AppleWebKit/<WebKit Rev> (KHTML, like Gecko) Chrome/<Chrome Rev> Mobile Safari/<WebKit Rev>";

	public static String callDialigFlow(String requestText) throws ClientProtocolException, IOException {
		String url = URL.replace("{1}",URLEncoder.encode(requestText));
		HttpGet request = new HttpGet(url);

		// add request header
		request.addHeader("User-Agent", USER_AGENT);
		//request.addHeader("Authorization","Bearer 8883a526d7394d6bafa7b3f9a13d2935");
		request.addHeader("Authorization","Bearer b18648df543d49c0a87d67f3ddb908da");
		HttpResponse response = client.execute(request);

		System.out.println("Response Code : "
		                + response.getStatusLine().getStatusCode());

		
		BufferedReader rd = new BufferedReader(
			new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		JSONObject json = new JSONObject(result.toString());
		JSONObject resultJ = (JSONObject)json.get("result");
		JSONObject fulfillment = (JSONObject)resultJ.get("fulfillment");
		JSONArray messages = (JSONArray)fulfillment.get("messages");
		String responseText = (String)((JSONObject)messages.get(0)).get("speech");
		return responseText;
		
	}
	
	public static String callGoogleTranslation(String requestText) throws ClientProtocolException, IOException {
		String url = GOOGLE_TRANSLATION.replace("{1}",URLEncoder.encode(requestText));
		HttpGet request = new HttpGet(url);

		// add request header
		request.addHeader("User-Agent", USER_AGENT);
		HttpResponse response = client.execute(request);

		System.out.println("Response Code : "
		                + response.getStatusLine().getStatusCode());

		
		BufferedReader rd = new BufferedReader(
			new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		JSONObject json = new JSONObject(result.toString());
		JSONObject data = (JSONObject)json.get("data");
		JSONArray translations = (JSONArray)data.get("translations");
		JSONObject translation = (JSONObject)translations.get(0);
		return (String)translation.get("translatedText");
	}
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		System.out.println(callGoogleTranslation("உன் வயது என்ன?"));
	}
	
}
