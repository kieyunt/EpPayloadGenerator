package com.ac.model.fl.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ac.model.BaseEntity;
import com.ac.model.pm.PmAddressType;

@Entity
@Table(name="FL_DELIVERY_ADDRESS")
public class FlDeliveryAddress extends BaseEntity {
	
	@Id
	@Column(name="DELIVERY_ADDRESS_ID")
	private Long deliveryAddressId;

	@Column(name="PM_ADDRESS_ID")
	private Long pmAddressId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="RECEIVING_GRP_ADDR_ID")
	private PmAddressType receivingGrp;

	public Long getDeliveryAddressId() {
		return deliveryAddressId;
	}

	public void setDeliveryAddressId(Long deliveryAddressId) {
		this.deliveryAddressId = deliveryAddressId;
	}

	public Long getPmAddressId() {
		return pmAddressId;
	}

	public void setPmAddressId(Long pmAddressId) {
		this.pmAddressId = pmAddressId;
	}

	public PmAddressType getReceivingGrp() {
		return receivingGrp;
	}

	public void setReceivingGrp(PmAddressType receivingGrp) {
		this.receivingGrp = receivingGrp;
	}
	
}
