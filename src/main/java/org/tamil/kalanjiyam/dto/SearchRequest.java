package org.tamil.kalanjiyam.dto;

import java.util.Map;

public class SearchRequest {
	
	public static final String START = "Start";
	public static final String LIMIT = "Limit";
	public static final String TEXT = "Text";
	public static final String CONTENT = "Content";
	
	private Integer start;	
	private Integer limit;	
	private String content;	
	private String text;	
	private Map<String, String> tags;
	
	public Integer getStart() {
		return start!=null?start:Integer.valueOf(0);
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Map<String, String> getTags() {
		return tags;
	}

	public void setTags(Map<String, String> tags) {
		this.tags = tags;
	}

}
