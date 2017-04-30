package org.tamil.kalanjiyam.dto;

import java.io.Serializable;

public class Item implements Serializable {

	private Integer id;
	
	private String identifier;
	
	private String content;
	
	private String explanation;
	
	private String explanationBy;
	
	private String situation;
	
	private String genre;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public String getExplanationBy() {
		return explanationBy;
	}

	public void setExplanationBy(String explanationBy) {
		this.explanationBy = explanationBy;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
}
