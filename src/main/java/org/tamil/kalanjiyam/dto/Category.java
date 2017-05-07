package org.tamil.kalanjiyam.dto;

import java.io.Serializable;

public class Category implements Serializable {
	
	private Integer id;
	
	private String description;
	
	private String year;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	
	
}
