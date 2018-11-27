package com.ac.service.fl.fulfilment;

import com.ac.model.dao.DAODelegate;
import com.ac.model.dao.fl.fulfilment.DeliveryOrderDAO;
import com.ac.model.fl.fulfilment.FlDeliveryOrder;

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
		deliveryOrderDataType.setDoId(flDeliveryOrder.getDeliveryOrderId());
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
