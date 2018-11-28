package com.ac.model.fl.order;

import java.math.BigDecimal;
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
import com.ac.model.pm.PmAgOffice;

@Entity
@Table(name="FL_FULFILMENT_REQUEST")
public class FlFulfilmentRequest extends BaseEntity {

	@Id
	@Column(name="FULFILMENT_REQ_ID")
	private Long fulfilmentReqId;
	
	@Column(name="DOC_NO")
	private String docNo;
	
	@Column(name="DOC_TYPE")
	private String docType;

	@Column(name="FINANCIAL_YEAR")
	private Integer financialYear;

	@Column(name="IS_MTO")
	private boolean isMto;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AG_OFFICE_ID")
	private PmAgOffice agOffice;

	@Column(name="AG_OFFICE_NAME")
	private String agOfficeName;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="SCHEDULE_NO")
	private String scheduleNo;
	
	@Column(name="DELIVERY_TERM")
	private Integer deliveryTerm;
	
	@Column(name="APPROVER_ID")
	private Long approverId;
	
	@Temporal(TemporalType.DATE)
	@Column(name="START_DATE")
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="SUBMISSION_DATE")
	private Date submissionDate;
	
	@Column(name="PHIS_NO")
	private String phisNo;
	
	@Column(name="PURCHASE_REQUEST_ID")
	private Long scPurchaseRequestId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="AG_APPROVED_DATE")
	private Date agApprovedDate;
	
	@Column(name="CHARGE_ORG_PROFILE_ID")
	private Long chargeOrgProfileId;

	@Column(name="CONTRACT_ID")
	private Long ctContractId;

	@Column(name="ISSUED_ORG_PROFILE_ID")
	private Long issuedOrgProfileId;

	@Column(name="SUPPLIER_ID")
	private Long smSupplierId;

	@Column(name="USER_GROUP_ID")
	private Long pmUserGroupId;	
	
	@Column(name="PROCUREMENT_TYPE_ID")
	private Long procurementTypeId;	
	
	@Column(name="PREPARED_ORG_PROFILE_ID")
	private Long preparedOrgProfileId;
	
	@Column(name="CREATED_ORG_PROFILE_ID")
	private Long createdOrgProfileId;
	
	@Column(name="UOM_ID")
	private Long pmUomId;
	
	@Column(name="PID_ID")
	private Long scPurchaseInDefaultId;
	
	@Column(name="CHARGE_ORG_ADDRESS_ID")
	private Long chargeOrgAddressId;
	
	@Column(name="ISSUED_ORG_ADDRESS_ID")
	private Long issueOrgAddressId;
	
	@Column(name="GST_REG_NO")
	private String gstRegNo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="GST_DECLARED_DATE")
	private Date gstDeclaredDate;
	
	@Column(name="PROCUREMENT_TYPE_CAT_ID")
	private Long procurementTypeCategoryId;
	
	@Temporal(TemporalType.DATE)
	@Column(name="GST_EFF_DATE")
	private Date gstEffectiveDate;
	
	@Column(name="GST_RATE")
	private BigDecimal gstRate;

	public Long getFulfilmentReqId() {
		return fulfilmentReqId;
	}

	public void setFulfilmentReqId(Long fulfilmentReqId) {
		this.fulfilmentReqId = fulfilmentReqId;
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

	public Integer getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(Integer financialYear) {
		this.financialYear = financialYear;
	}

	public boolean isMto() {
		return isMto;
	}

	public void setMto(boolean isMto) {
		this.isMto = isMto;
	}

	public PmAgOffice getAgOffice() {
		return agOffice;
	}

	public void setAgOffice(PmAgOffice agOffice) {
		this.agOffice = agOffice;
	}

	public String getAgOfficeName() {
		return agOfficeName;
	}

	public void setAgOfficeName(String agOfficeName) {
		this.agOfficeName = agOfficeName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getScheduleNo() {
		return scheduleNo;
	}

	public void setScheduleNo(String scheduleNo) {
		this.scheduleNo = scheduleNo;
	}

	public Integer getDeliveryTerm() {
		return deliveryTerm;
	}

	public void setDeliveryTerm(Integer deliveryTerm) {
		this.deliveryTerm = deliveryTerm;
	}

	public Long getApproverId() {
		return approverId;
	}

	public void setApproverId(Long approverId) {
		this.approverId = approverId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

	public String getPhisNo() {
		return phisNo;
	}

	public void setPhisNo(String phisNo) {
		this.phisNo = phisNo;
	}

	public Long getScPurchaseRequestId() {
		return scPurchaseRequestId;
	}

	public void setScPurchaseRequestId(Long scPurchaseRequestId) {
		this.scPurchaseRequestId = scPurchaseRequestId;
	}

	public Date getAgApprovedDate() {
		return agApprovedDate;
	}

	public void setAgApprovedDate(Date agApprovedDate) {
		this.agApprovedDate = agApprovedDate;
	}

	public Long getChargeOrgProfileId() {
		return chargeOrgProfileId;
	}

	public void setChargeOrgProfileId(Long chargeOrgProfileId) {
		this.chargeOrgProfileId = chargeOrgProfileId;
	}

	public Long getCtContractId() {
		return ctContractId;
	}

	public void setCtContractId(Long ctContractId) {
		this.ctContractId = ctContractId;
	}

	public Long getIssuedOrgProfileId() {
		return issuedOrgProfileId;
	}

	public void setIssuedOrgProfileId(Long issuedOrgProfileId) {
		this.issuedOrgProfileId = issuedOrgProfileId;
	}

	public Long getSmSupplierId() {
		return smSupplierId;
	}

	public void setSmSupplierId(Long smSupplierId) {
		this.smSupplierId = smSupplierId;
	}

	public Long getPmUserGroupId() {
		return pmUserGroupId;
	}

	public void setPmUserGroupId(Long pmUserGroupId) {
		this.pmUserGroupId = pmUserGroupId;
	}

	public Long getProcurementTypeId() {
		return procurementTypeId;
	}

	public void setProcurementTypeId(Long procurementTypeId) {
		this.procurementTypeId = procurementTypeId;
	}

	public Long getPreparedOrgProfileId() {
		return preparedOrgProfileId;
	}

	public void setPreparedOrgProfileId(Long preparedOrgProfileId) {
		this.preparedOrgProfileId = preparedOrgProfileId;
	}

	public Long getCreatedOrgProfileId() {
		return createdOrgProfileId;
	}

	public void setCreatedOrgProfileId(Long createdOrgProfileId) {
		this.createdOrgProfileId = createdOrgProfileId;
	}

	public Long getPmUomId() {
		return pmUomId;
	}

	public void setPmUomId(Long pmUomId) {
		this.pmUomId = pmUomId;
	}

	public Long getScPurchaseInDefaultId() {
		return scPurchaseInDefaultId;
	}

	public void setScPurchaseInDefaultId(Long scPurchaseInDefaultId) {
		this.scPurchaseInDefaultId = scPurchaseInDefaultId;
	}

	public Long getChargeOrgAddressId() {
		return chargeOrgAddressId;
	}

	public void setChargeOrgAddressId(Long chargeOrgAddressId) {
		this.chargeOrgAddressId = chargeOrgAddressId;
	}

	public Long getIssueOrgAddressId() {
		return issueOrgAddressId;
	}

	public void setIssueOrgAddressId(Long issueOrgAddressId) {
		this.issueOrgAddressId = issueOrgAddressId;
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

	public Long getProcurementTypeCategoryId() {
		return procurementTypeCategoryId;
	}

	public void setProcurementTypeCategoryId(Long procurementTypeCategoryId) {
		this.procurementTypeCategoryId = procurementTypeCategoryId;
	}

	public Date getGstEffectiveDate() {
		return gstEffectiveDate;
	}

	public void setGstEffectiveDate(Date gstEffectiveDate) {
		this.gstEffectiveDate = gstEffectiveDate;
	}

	public BigDecimal getGstRate() {
		return gstRate;
	}

	public void setGstRate(BigDecimal gstRate) {
		this.gstRate = gstRate;
	}
	
}
