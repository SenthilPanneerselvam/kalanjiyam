package org.tamil.kalanjiyam.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tags")
public class TagData {
	
	@Column(name="tag_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="tag_name")
	private String tagName;
	
	@Column(name="tag_value")
	private String tagValue;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="item_id")
	private ItemData item;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getTagValue() {
		return tagValue;
	}

	public void setTagValue(String tagValue) {
		this.tagValue = tagValue;
	}

	public ItemData getItem() {
		return item;
	}

	public void setItem(ItemData item) {
		this.item = item;
	}

}
