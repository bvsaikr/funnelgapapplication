package com.tataelxsi.fga.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Funnel_Project_Probability")
public class FunnelProjectProbability {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="Probability")
	private String probability;
	
	
	
	
	public FunnelProjectProbability() {
		super();
	}

	public FunnelProjectProbability(long id, String probability) {
		super();
		this.id= id;
		this.probability = probability;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProbability() {
		return probability;
	}

	public void setProbability(String probability) {
		this.probability = probability;
	}

	

}