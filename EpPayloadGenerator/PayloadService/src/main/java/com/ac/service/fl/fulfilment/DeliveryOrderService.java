package com.ac.service.fl.fulfilment;

import com.ac.model.dao.fl.fulfilment.DeliveryOrderDAO;
import com.ac.model.fl.fulfilment.FlDeliveryOrder;

import my.ep.jaxb.fl.dodata.FLDeliveryOrderDataType;
import my.ep.jaxb.fl.dodata.list.FLDeliveryOrderListDataType;

public class DeliveryOrderService {

	DeliveryOrderDAO deliveryOrderDAO = new DeliveryOrderDAO();
	/**
	 * Generate DO Payload
	 * @param documentId accept deliveryOrderId, deliveryOrderNo
	 * @throws Exception 
	 */
	public void generateDeliveryOrderPayload(String documentId) throws Exception {
		FLDeliveryOrderListDataType doList = new FLDeliveryOrderListDataType();
		FLDeliveryOrderDataType deliveryOrderDataType = new FLDeliveryOrderDataType();
		
		deliveryOrderDataType.setDoId(findDeliveryOrderId(documentId));
	}
	
	private Long findDeliveryOrderId(String documentId) throws Exception {
		if(documentId.length()==17) { // DO
			FlDeliveryOrder flDeliveryOrder = deliveryOrderDAO.retrieveDeliveryOrderByNo(documentId);
			if(flDeliveryOrder==null) {
				throw new Exception("Invalid Delivery Order No. :"+documentId);
			}
			return flDeliveryOrder.getDeliveryOrderId();
		} else {
			return new Long(documentId);
		}
	}
	
}
