package com.tataelxsi.fga.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Funnel_Project_Category")
public class FunnelProjectCategory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="Category")
     private String category;
	
	

	public FunnelProjectCategory() {
		super();
	}

	

	public FunnelProjectCategory(long id, String category) {
		super();
		this.id= id;
		this.category = category;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	



}