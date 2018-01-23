package org.tamil.kalanjiyam.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.MessageFormat;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

public class HttpUtils {
	
	private static HttpClient client = HttpClientBuilder.create().build();
	private static final String URL = "https://api.dialogflow.com/v1/query?v=20170712&query={1}&lang=en&sessionId=ce337b9a-23f2-4c67-bf67-798edb75f739&timezone=Asia/Calcutta";
	
	private static final String USER_AGENT = "Mozilla/5.0 (Linux; <Android Version>; <Build Tag etc.>) AppleWebKit/<WebKit Rev> (KHTML, like Gecko) Chrome/<Chrome Rev> Mobile Safari/<WebKit Rev>";

	public static String callDialigFlow(String requestText) throws ClientProtocolException, IOException {
		String url = URL.replace("{1}",requestText);
		HttpGet request = new HttpGet(url);

		// add request header
		request.addHeader("User-Agent", USER_AGENT);
		request.addHeader("Authorization","Bearer 8883a526d7394d6bafa7b3f9a13d2935");
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
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		System.out.println(callDialigFlow("age?"));
	}
	
}
