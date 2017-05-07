package org.tamil.kalanjiyam.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class ItemData implements Serializable {

	@Column(name="item_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="item_name")
	private String name;
	
	@Column(name="item_content")
	private String content;
	
	@Column(name="item_exp")
	private String explanation;
	
	@Column(name="item_exp_by")
	private String explanationBy;
	
	@Column(name="item_situation")
	private String situation;
	
	@Column(name="item_genre")
	private String genre;
	
	@Column(name="author")
	private String author;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cat_id")
	private CategoryData category;
	
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
	private List<TagData> tags;

	public List<TagData> getTags() {
		return tags;
	}

	public void setTags(List<TagData> tags) {
		this.tags = tags;
	}

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
	
	public CategoryData getCategory() {
		return category;
	}

	public void setCategory(CategoryData category) {
		this.category = category;
	}
}
