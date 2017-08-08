package org.tamil.kalanjiyam.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class CategoryData implements Serializable {
	
	private static final long serialVersionUID = -1289322823668948304L;

	@Column(name="cat_id")
	@Id
	private Integer id;
	
	@Column(name="cat_name")
	private String name;
	
	@Column(name="cat_desc")
	private String description;
	
	@Column(name="cat_pub_year")
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
