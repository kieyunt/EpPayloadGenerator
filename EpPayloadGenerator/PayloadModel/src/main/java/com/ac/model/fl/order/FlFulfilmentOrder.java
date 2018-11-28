package com.ac.model.fl.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ac.model.BaseEntity;

@Entity
@Table(name="FL_FULFILMENT_ORDER")
public class FlFulfilmentOrder extends BaseEntity {

	@Id
	@Column(name="FULFILMENT_ORDER_ID")
	private Long fulfilmentOrderId;

	@Column(name="DOC_NO")
	private String docNo;

	@Column(name="DOC_TYPE")
	private String docType;

	@Column(name="SAP_ORDER_NO")
	private String sapOrderNo;

	public Long getFulfilmentOrderId() {
		return fulfilmentOrderId;
	}

	public void setFulfilmentOrderId(Long fulfilmentOrderId) {
		this.fulfilmentOrderId = fulfilmentOrderId;
	}

	public String getDocNo() {
		return docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getSapOrderNo() {
		return sapOrderNo;
	}

	public void setSapOrderNo(String sapOrderNo) {
		this.sapOrderNo = sapOrderNo;
	}
	
}
