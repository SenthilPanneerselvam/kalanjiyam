package org.tamil.kalanjiyam.dto;

import java.io.Serializable;
import java.util.List;

public class Item implements Serializable {

	private Integer id;
	
	private String name;
	
	private String content;
	
	private String explanation;
	
	private String explanationBy;
	
	private String situation;
	
	private String genre;
	
	private String author;
	
	private List<Tag> tags;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
}
