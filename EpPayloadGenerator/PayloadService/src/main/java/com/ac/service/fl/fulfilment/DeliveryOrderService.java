package com.ac.service.fl.fulfilment;

import java.util.Date;

import com.ac.model.dao.DAODelegate;
import com.ac.model.dao.fl.fulfilment.DeliveryOrderDAO;
import com.ac.model.fl.fulfilment.FlDeliveryOrder;
import com.ac.util.BpmCommonUtils;

import my.ep.jaxb.fl.dodata.FLDeliveryOrderDataType;
import my.ep.jaxb.fl.dodata.list.FLDeliveryOrderListDataType;

public class DeliveryOrderService {

	/**
	 * Generate DO Payload
	 * @param documentId accept deliveryOrderId, deliveryOrderNo
	 * @throws Exception 
	 */
	public void generateDeliveryOrderPayload(String documentId) throws Exception {
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
