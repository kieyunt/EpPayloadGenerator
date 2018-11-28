package com.ac.model.pm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ac.model.BaseEntity;

@Entity
@Table(name = "PM_AG_OFFICE")
public class PmAgOffice extends BaseEntity {

	@Id
	@Column(name = "AG_OFFICE_ID")
	private Long agOfficeId;

	@Column(name = "OFFICE_CODE")
	private String officeCode;

	public Long getAgOfficeId() {
		return agOfficeId;
	}

	public void setAgOfficeId(Long agOfficeId) {
		this.agOfficeId = agOfficeId;
	}

	public String getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}
	
}
