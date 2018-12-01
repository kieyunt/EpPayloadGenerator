package com.ac.service.fl.fulfilment;

import java.util.Date;
import java.util.List;

import com.ac.model.dao.DAODelegate;
import com.ac.model.dao.fl.fulfilment.DeliveryOrderDAO;
import com.ac.model.dao.pm.AddressTypeDAO;
import com.ac.model.dao.sm.SmPersonnelDAO;
import com.ac.model.fl.fulfilment.FlDeliveryOrder;
import com.ac.model.pm.PmAddressType;
import com.ac.model.sm.SmPersonnel;
import com.ac.util.BpmCommonUtils;
import com.ac.util.xml.Parser;

import my.ep.jaxb.fl.common.user.FLUserDataType;
import my.ep.jaxb.fl.dodata.FLDeliveryOrderDataType;
import my.ep.jaxb.fl.dodata.list.FLDeliveryOrderListDataType;

public class DeliveryOrderService {

	private static String CALENDAR_PUTRAJAYA = "PUTRAJAYA";
	
	/**
	 * Generate DO Payload
	 * @param documentId accept deliveryOrderId, deliveryOrderNo
	 * @throws Exception 
	 */
	public void generateDeliveryOrderPayload(String documentId) throws Exception {
		AddressTypeDAO addressTypeDAO = DAODelegate.getInstance().getDataObject(AddressTypeDAO.class);
		SmPersonnelDAO personnelDAO = DAODelegate.getInstance().getDataObject(SmPersonnelDAO.class);
		
		FLDeliveryOrderListDataType doList = new FLDeliveryOrderListDataType();
		FLDeliveryOrderDataType deliveryOrderDataType = new FLDeliveryOrderDataType();
		
		FlDeliveryOrder flDeliveryOrder = findDeliveryOrderId(documentId);
		
		if(flDeliveryOrder.getFlRequest().getPhisNo()!=null) {
			deliveryOrderDataType.setIsPhis(true);
		}
		deliveryOrderDataType.setDoId(flDeliveryOrder.getDeliveryOrderId());
		deliveryOrderDataType.setDoDocNo(flDeliveryOrder.getDeliveryOrderNo());
		deliveryOrderDataType.setSupplierDoNo(flDeliveryOrder.getSupplierDoRef());
		deliveryOrderDataType.setSupplierDoDate(BpmCommonUtils.getCalendarValue(new Date(flDeliveryOrder.getCreatedDate().getTime())));
		
		//Setting the order info to do.
		deliveryOrderDataType.setOrderDocNo(flDeliveryOrder.getFlFulfilmentOrder().getDocNo());
		deliveryOrderDataType.setRequestId(flDeliveryOrder.getFlRequest().getFulfilmentReqId());
		deliveryOrderDataType.setOrderId(flDeliveryOrder.getFlFulfilmentOrder().getFulfilmentOrderId());
		deliveryOrderDataType.setOrderType(flDeliveryOrder.getFlFulfilmentOrder().getDocType());
		deliveryOrderDataType.setOrderName(flDeliveryOrder.getFlRequest().getTitle());
		deliveryOrderDataType.setSapOrderNo(flDeliveryOrder.getFlFulfilmentOrder().getSapOrderNo());
		deliveryOrderDataType.setBusinessArea(flDeliveryOrder.getFlRequest().getAgOffice().getOfficeCode());
		
		//Get receiving officer list
		Long addressId = flDeliveryOrder.getFlDeliveryAddress().getPmAddressId();
		if(flDeliveryOrder.getFlDeliveryAddress().getReceivingGrp()!=null && flDeliveryOrder.getFlDeliveryAddress().getReceivingGrp().getAddressTypeId()!=null) { // in case of Manual address
			addressId = flDeliveryOrder.getFlDeliveryAddress().getReceivingGrp().getPmAddressId();
		}
		List<PmAddressType> addressTypeList = addressTypeDAO.retrieveAddressType("R", addressId);
		for(PmAddressType addressType : addressTypeList) {
			if(addressType.getPmUser().getRecordStatusFlg().intValue()==1) {
				FLUserDataType userDataType = new FLUserDataType();
				userDataType.setUserId(addressType.getPmUser().getUserId());
				userDataType.setUserLoginId(addressType.getPmUser().getLoginId());
				userDataType.setUserName(BpmCommonUtils.trimUserNameAsIDD(addressType.getPmUser().getUserName()));
				userDataType.setCalendarName(CALENDAR_PUTRAJAYA);
				userDataType.setDesignation(BpmCommonUtils.trimDesignationAsIDD(addressType.getPmUser().getDesignation()));
				deliveryOrderDataType.getReceivingOfficerList().add(userDataType);
			}
		}
		doList.getDeliveryOrderList().add(deliveryOrderDataType);
		
		List<SmPersonnel> personnelList = personnelDAO.retrieveSmPersonnel(flDeliveryOrder.getFlRequest().getSmSupplierId());
		int size = 0; 
		for(SmPersonnel personnel : personnelList){
			size = size + personnel.getPmUser().getLoginId().length() + 1;
			if(size>1000) {
				break;
			}
			FLUserDataType suppliers = new FLUserDataType();
			suppliers.setUserId(personnel.getPmUser().getUserId());
			suppliers.setUserLoginId(personnel.getPmUser().getLoginId());
			suppliers.setUserName(BpmCommonUtils.trimUserNameAsIDD(personnel.getPmUser().getUserName()));
			suppliers.setCalendarName(CALENDAR_PUTRAJAYA);
			suppliers.setDesignation(BpmCommonUtils.trimDesignationAsIDD(personnel.getPmUser().getDesignation()));
			doList.getSupplierList().add(suppliers);
		}
		
		String xml = "<!-- Submit DO -->\r\n"+Parser.getInstance().parseObj(doList).replaceAll("\n", "\r\n");	
		System.out.println(xml);
	}
	
	private FlDeliveryOrder findDeliveryOrderId(String documentId) throws Exception {
		DeliveryOrderDAO deliveryOrderDAO = DAODelegate.getInstance().getDataObject(DeliveryOrderDAO.class);
		FlDeliveryOrder flDeliveryOrder = null;
		if(documentId.length()==17) { // DO
			flDeliveryOrder = deliveryOrderDAO.retrieveDeliveryOrderByNo(documentId);
			if(flDeliveryOrder==null) {
				throw new Exception("Invalid Delivery Order No. :"+documentId);
			}
		} else {
			flDeliveryOrder = deliveryOrderDAO.retrieveDeliveryOrderById(Long.valueOf(documentId));
			if(flDeliveryOrder==null) {
				throw new Exception("Invalid Delivery Order ID :"+documentId);
			}
		}
		return flDeliveryOrder;
	}
	
}
