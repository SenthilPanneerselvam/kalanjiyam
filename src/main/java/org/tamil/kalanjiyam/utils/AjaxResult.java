package org.tamil.kalanjiyam.utils;


import java.util.List;

import org.tamil.kalanjiyam.dto.ChatResponse;

public class AjaxResult   { 
	/**
	 * 
	 */

	private List<ChatResponse> data;
	public void setData(List<ChatResponse> data){
		this.data = data;
	}
	public List<ChatResponse> getData(){
		return data;
	}
}
