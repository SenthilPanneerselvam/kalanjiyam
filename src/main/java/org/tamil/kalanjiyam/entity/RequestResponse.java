package org.tamil.kalanjiyam.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.tamil.kalanjiyam.dto.ChatResponse;

@Document(collection="request")
public class RequestResponse {
	
	@Id
	private String id;
	
	private String request;
	
	private ChatResponse response;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public ChatResponse getResponse() {
		return response;
	}

	public void setResponse(ChatResponse response) {
		this.response = response;
	}

}
