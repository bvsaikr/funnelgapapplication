package com.tataelxsi.fga.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Funnel_Project_Stage")
public class FunnelProjectStage {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="Stage")
	private String Stage;
	
	

	public FunnelProjectStage() {
		super();
	}

	public FunnelProjectStage(long id, String stage) {
		super();
		this.id= id;
		this.Stage = stage;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStage() {
		return Stage;
	}

	public void setStage(String stage) {
		Stage = stage;
	}

	

}