package org.tamil.kalanjiyam.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

public class RetrieveThirukkural {

	private static final String USER_AGENT = "Mozilla/5.0 (Linux; <Android Version>; <Build Tag etc.>) AppleWebKit/<WebKit Rev> (KHTML, like Gecko) Chrome/<Chrome Rev> Mobile Safari/<WebKit Rev>";

	private static final StringBuilder resultQ = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		

		HttpClient client = HttpClientBuilder.create().build();
		for (int cIndex =1;cIndex<134;cIndex++) {
			String url = "http://api.gokulnath.com/thirukkuralchapters/"+cIndex+"/thirukkurals";
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
			System.out.println(result);
			JSONObject json = new JSONObject(result.toString());
			JSONArray list = (JSONArray)json.get("Data");
			int arrayLength = list.length();
			for (int i=0;i<arrayLength;i++) {
				JSONObject item = (JSONObject)list.get(i);
				appendQuery(item);
			}
		}
		
		System.out.println(resultQ.toString());
	}
	
	private static void appendQuery(JSONObject obj) {
		resultQ.append("INSERT INTO item(item_id,item_name,item_content,item_exp,cat_id) values(");
		int index = obj.getInt("Index");
		resultQ.append(index);
		resultQ.append(",'" + index + "',");
		String content = obj.getString("Tamil");
		content = content.replace("'", "");
		resultQ.append("'" + content + "',");
		String exp = obj.getString("KalaignarUrai");
		exp = exp.replace("'", "");
		resultQ.append("'" + exp + "',1);");
	}
	
}
