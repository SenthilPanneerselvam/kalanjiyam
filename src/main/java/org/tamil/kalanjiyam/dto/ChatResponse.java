package org.tamil.kalanjiyam.dto;

import java.util.Date;

public class ChatResponse {
	
	private String msg;
	
	private String type;
	
	private Date responseTime;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(Date responseTime) {
		this.responseTime = responseTime;
	}
	

}
