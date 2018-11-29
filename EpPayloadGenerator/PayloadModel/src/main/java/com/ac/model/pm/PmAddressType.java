package com.ac.model.pm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ac.model.BaseEntity;

@Entity
@Table(name="PM_ADDRESS_TYPE")
public class PmAddressType extends BaseEntity {

	@Id
	@Column(name="ADDRESS_TYPE_ID")
	private Long addressTypeId;

	@Column(name="ADDRESS_TYPE")
	private String addressType;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID")
	private PmUser pmUser;
	
	@Column(name="ORG_PROFILE_ID")
	private Long pmOrgProfileId;
	
	@Column(name="ADDRESS_ID")
	private Long pmAddressId;

	public Long getAddressTypeId() {
		return addressTypeId;
	}

	public void setAddressTypeId(Long addressTypeId) {
		this.addressTypeId = addressTypeId;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public PmUser getPmUser() {
		return pmUser;
	}

	public void setPmUser(PmUser pmUser) {
		this.pmUser = pmUser;
	}

	public Long getPmOrgProfileId() {
		return pmOrgProfileId;
	}

	public void setPmOrgProfileId(Long pmOrgProfileId) {
		this.pmOrgProfileId = pmOrgProfileId;
	}

	public Long getPmAddressId() {
		return pmAddressId;
	}

	public void setPmAddressId(Long pmAddressId) {
		this.pmAddressId = pmAddressId;
	}
	
}
