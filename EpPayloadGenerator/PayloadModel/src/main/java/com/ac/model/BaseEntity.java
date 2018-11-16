package com.ac.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {
	
	@Column(name="RECORD_STATUS")
	private Integer recordStatusFlg;
	
	@Column(name = "CREATED_DATE")
	private Timestamp createdDate;

	@Column(name = "CREATED_BY")
	private Long createdBy;

	@Column(name = "CHANGED_DATE")
	private Timestamp changedDate;

	@Column(name = "CHANGED_BY")
	private Long changedBy;

	public Integer getRecordStatusFlg() {
		return recordStatusFlg;
	}

	public void setRecordStatusFlg(Integer recordStatusFlg) {
		this.recordStatusFlg = recordStatusFlg;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getChangedDate() {
		return changedDate;
	}

	public void setChangedDate(Timestamp changedDate) {
		this.changedDate = changedDate;
	}

	public Long getChangedBy() {
		return changedBy;
	}

	public void setChangedBy(Long changedBy) {
		this.changedBy = changedBy;
	}
	
}
