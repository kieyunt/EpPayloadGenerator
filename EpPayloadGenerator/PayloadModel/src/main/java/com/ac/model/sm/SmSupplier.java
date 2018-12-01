package com.ac.model.sm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ac.model.BaseEntity;

@Entity
@Table(name="SM_SUPPLIER")
public class SmSupplier extends BaseEntity {

	@Id
	@Column(name = "SUPPLIER_ID")
	private Long supplierId;
	
	@Column(name = "EP_NO")
	private String epNo;
	
	@Column(name = "COMPANY_NAME")
	private String companyName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LATEST_APPL_ID")
	private SmAppl smAppl;

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public String getEpNo() {
		return epNo;
	}

	public void setEpNo(String epNo) {
		this.epNo = epNo;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public SmAppl getSmAppl() {
		return smAppl;
	}

	public void setSmAppl(SmAppl smAppl) {
		this.smAppl = smAppl;
	}
	
}
