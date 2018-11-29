package com.ac.model.fl.fulfilment;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ac.model.BaseEntity;
import com.ac.model.fl.order.FlDeliveryAddress;
import com.ac.model.fl.order.FlFulfilmentOrder;
import com.ac.model.fl.order.FlFulfilmentRequest;

@Entity
@Table(name="FL_DELIVERY_ORDER")
public class FlDeliveryOrder extends BaseEntity {
	
	@Id
	@Column(name="DELIVERY_ORDER_ID")
	private Long deliveryOrderId;

	@Column(name="DELIVERY_ORDER_NO")
	private String deliveryOrderNo;

	@Temporal(TemporalType.DATE)
	@Column(name="EST_END_DATE")
	private Date estEndDate;

	@Temporal(TemporalType.DATE)
	@Column(name="EST_START_DATE")
	private Date estStartDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="EST_DELIVERY_DATE")
	private Date estDeliveryDate;
	
	@Column(name="SUPPLIER_DO_REF")
	private String supplierDoRef;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DELIVERY_ADDRESS_ID")
	private FlDeliveryAddress flDeliveryAddress;

	@ManyToOne
	@JoinColumn(name="FULFILMENT_ORDER_ID")
	private FlFulfilmentOrder flFulfilmentOrder;
	
	@ManyToOne
	@JoinColumn(name="FULFILMENT_REQ_ID")
	private FlFulfilmentRequest flRequest;

	@Column(name="GST_REG_NO")
	private String gstRegNo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="GST_DECLARED_DATE")
	private Date gstDeclaredDate;
		
	@Temporal(TemporalType.DATE)
	@Column(name="GST_EFF_DATE")
	private Date gstEffectiveDate;

	public Long getDeliveryOrderId() {
		return deliveryOrderId;
	}

	public void setDeliveryOrderId(Long deliveryOrderId) {
		this.deliveryOrderId = deliveryOrderId;
	}

	public String getDeliveryOrderNo() {
		return deliveryOrderNo;
	}

	public void setDeliveryOrderNo(String deliveryOrderNo) {
		this.deliveryOrderNo = deliveryOrderNo;
	}

	public Date getEstEndDate() {
		return estEndDate;
	}

	public void setEstEndDate(Date estEndDate) {
		this.estEndDate = estEndDate;
	}

	public Date getEstStartDate() {
		return estStartDate;
	}

	public void setEstStartDate(Date estStartDate) {
		this.estStartDate = estStartDate;
	}

	public Date getEstDeliveryDate() {
		return estDeliveryDate;
	}

	public void setEstDeliveryDate(Date estDeliveryDate) {
		this.estDeliveryDate = estDeliveryDate;
	}

	public String getSupplierDoRef() {
		return supplierDoRef;
	}

	public void setSupplierDoRef(String supplierDoRef) {
		this.supplierDoRef = supplierDoRef;
	}

	public FlDeliveryAddress getFlDeliveryAddress() {
		return flDeliveryAddress;
	}

	public void setFlDeliveryAddress(FlDeliveryAddress flDeliveryAddress) {
		this.flDeliveryAddress = flDeliveryAddress;
	}

	public FlFulfilmentOrder getFlFulfilmentOrder() {
		return flFulfilmentOrder;
	}

	public void setFlFulfilmentOrder(FlFulfilmentOrder flFulfilmentOrder) {
		this.flFulfilmentOrder = flFulfilmentOrder;
	}

	public FlFulfilmentRequest getFlRequest() {
		return flRequest;
	}

	public void setFlRequest(FlFulfilmentRequest flRequest) {
		this.flRequest = flRequest;
	}

	public String getGstRegNo() {
		return gstRegNo;
	}

	public void setGstRegNo(String gstRegNo) {
		this.gstRegNo = gstRegNo;
	}

	public Date getGstDeclaredDate() {
		return gstDeclaredDate;
	}

	public void setGstDeclaredDate(Date gstDeclaredDate) {
		this.gstDeclaredDate = gstDeclaredDate;
	}

	public Date getGstEffectiveDate() {
		return gstEffectiveDate;
	}

	public void setGstEffectiveDate(Date gstEffectiveDate) {
		this.gstEffectiveDate = gstEffectiveDate;
	}
	
}
