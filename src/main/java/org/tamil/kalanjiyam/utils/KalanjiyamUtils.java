package org.tamil.kalanjiyam.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.tamil.kalanjiyam.dto.SearchRequest;

public class KalanjiyamUtils {

	public static SearchRequest getSearchRequest(Map<String, String> params) {
		SearchRequest searchRequest = new SearchRequest();
		Map<String,String> tags = new HashMap<>();
		searchRequest.setTags(tags);
		for (Entry<String,String> param : params.entrySet()) {
			if (SearchRequest.START.equalsIgnoreCase(param.getKey())) {
				searchRequest.setStart(Integer.parseInt(param.getValue()));
			} else if (SearchRequest.LIMIT.equalsIgnoreCase(param.getKey())) {
				searchRequest.setLimit(Integer.parseInt(param.getValue()));
			} else if (SearchRequest.TEXT.equalsIgnoreCase(param.getKey())) {
				searchRequest.setText(param.getValue());
			} else if (SearchRequest.CONTENT.equalsIgnoreCase(param.getKey())) {
				searchRequest.setContent(param.getValue());
			} else {
				tags.put(param.getKey(), param.getValue());
			} 
		}
		
		return searchRequest;
	}
	
}
