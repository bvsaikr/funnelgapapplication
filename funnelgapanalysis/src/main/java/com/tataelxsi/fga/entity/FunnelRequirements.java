package com.tataelxsi.fga.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Funnel_Requirements")
public class FunnelRequirements {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column(name="Funnel_Id")
	private long funnelId;
	
	@Column(name="Job_Description",columnDefinition="TEXT")
	private String jobDescription;
	@Column(name="Number_Of_Positions")
	private long numberOfPositions;
	@Column(name="Reserved_No")
	private long reservedNo;
	@Column (name="Reserved_Emp_No")
	private String reservedEmpNo;

	
	@Column(name="Remarks",columnDefinition="TEXT")
    private String remarks;
	@Column(name="Requirement_Date")
	private Date requirementDate;
	
	@OneToOne
    @JoinColumn(name = "funnel_buc_id", referencedColumnName = "id")
    private FunnelBuc fBuc;
	
	@OneToOne
    @JoinColumn(name = "funnel_customer_id", referencedColumnName = "id")
    private FunnelCustomer fCust;
	
	@OneToOne
    @JoinColumn(name = "funnel_project_id", referencedColumnName = "id")
    private FunnelProject fProj;
	
	@OneToOne
    @JoinColumn(name = "funnel_Project_Category_id", referencedColumnName = "id")
    private FunnelProjectCategory fProjCat;
	
	@OneToOne
    @JoinColumn(name = "funnel_Project_Probability_id", referencedColumnName = "id")
    private FunnelProjectProbability fProjProb;
	
	@OneToOne
    @JoinColumn(name = "funnel_Project_Stage_id", referencedColumnName = "id")
    private FunnelProjectStage fProjStage;
	
	@OneToOne
    @JoinColumn(name = "funnel_Skill_id", referencedColumnName = "id")
    private FunnelSkill fSkill;
	
	
	
	
	
	
	public FunnelRequirements() {
		super();
	}

	public FunnelRequirements(long id, long funnelId, String jobDescription, long numberOfPositions, long reservedNo,
			String reservedEmpNo, String remarks, Date requirementDate) {
		super();
		this.id = id;
		this.funnelId = funnelId;
		this.jobDescription = jobDescription;
		this.numberOfPositions = numberOfPositions;
		this.reservedNo = reservedNo;
		this.reservedEmpNo = reservedEmpNo;
		this.remarks = remarks;
		this.requirementDate = requirementDate;
		
		
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getFunnelId() {
		return funnelId;
	}

	public void setFunnelId(long funnelId) {
		this.funnelId = funnelId;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public long getNumberOfPositions() {
		return numberOfPositions;
	}

	public void setNumberOfPositions(long numberOfPositions) {
		this.numberOfPositions = numberOfPositions;
	}

	public long getReservedNo() {
		return reservedNo;
	}

	public void setReservedNo(long reservedNo) {
		this.reservedNo = reservedNo;
	}

	public String getReservedEmpNo() {
		return reservedEmpNo;
	}

	public void setReservedEmpNo(String reservedEmpNo) {
		this.reservedEmpNo = reservedEmpNo;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getRequirementDate() {
		return requirementDate;
	}

	public void setRequirementDate(Date requirementDate) {
		this.requirementDate = requirementDate;
	}

	public FunnelBuc getfBuc() {
		return fBuc;
	}

	public void setfBuc(FunnelBuc fBuc) {
		this.fBuc = fBuc;
	}

	public FunnelCustomer getfCust() {
		return fCust;
	}

	public void setfCust(FunnelCustomer fCust) {
		this.fCust = fCust;
	}

	public FunnelProject getfProj() {
		return fProj;
	}

	public void setfProj(FunnelProject fProj) {
		this.fProj = fProj;
	}

	public FunnelProjectCategory getfProjCat() {
		return fProjCat;
	}

	public void setfProjCat(FunnelProjectCategory fProjCat) {
		this.fProjCat = fProjCat;
	}

	public FunnelProjectProbability getfProjProb() {
		return fProjProb;
	}

	public void setfProjProb(FunnelProjectProbability fProjProb) {
		this.fProjProb = fProjProb;
	}

	public FunnelProjectStage getfProjStage() {
		return fProjStage;
	}

	public void setfProjStage(FunnelProjectStage fProjStage) {
		this.fProjStage = fProjStage;
	}

	public FunnelSkill getfSkill() {
		return fSkill;
	}

	public void setfSkill(FunnelSkill fSkill) {
		this.fSkill = fSkill;
	}

}