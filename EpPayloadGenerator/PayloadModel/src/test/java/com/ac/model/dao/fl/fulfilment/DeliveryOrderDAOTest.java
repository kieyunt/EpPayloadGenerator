package com.ac.model.dao.fl.fulfilment;

import com.ac.model.fl.fulfilment.FlDeliveryOrder;

import junit.framework.TestCase;

public class DeliveryOrderDAOTest extends TestCase {

	DeliveryOrderDAO deliveryOrderDAO; 
	
	@Override
	protected void setUp() throws Exception{
		deliveryOrderDAO = new DeliveryOrderDAO();
	}
	
	@Override
	protected void tearDown() throws Exception {
		deliveryOrderDAO = null;
	}
	
	public void testRetrieveDeliveryOrderById() {
		FlDeliveryOrder deliveryOrder = deliveryOrderDAO.retrieveDeliveryOrderById(104l);
		System.out.println("Object : "+deliveryOrder);
		if(deliveryOrder!=null) {
			System.out.println("Document ID : "+deliveryOrder.getDeliveryOrderId());
			System.out.println("Document number : "+deliveryOrder.getDeliveryOrderNo());
		}
		assertTrue(deliveryOrder!=null);
	}
	
}
