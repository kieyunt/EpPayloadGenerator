package com.ac.model.sm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ac.model.BaseEntity;
import com.ac.model.pm.PmUser;

@Entity
@Table(name="SM_PERSONNEL")
public class SmPersonnel extends BaseEntity {

	@Id
	@Column(name = "PERSONNEL_ID")
	private Long personnelId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private PmUser pmUser;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "APPL_ID")
	private SmAppl smAppl;

	public Long getPersonnelId() {
		return personnelId;
	}

	public void setPersonnelId(Long personnelId) {
		this.personnelId = personnelId;
	}

	public PmUser getPmUser() {
		return pmUser;
	}

	public void setPmUser(PmUser pmUser) {
		this.pmUser = pmUser;
	}

	public SmAppl getSmAppl() {
		return smAppl;
	}

	public void setSmAppl(SmAppl smAppl) {
		this.smAppl = smAppl;
	}
	
}
