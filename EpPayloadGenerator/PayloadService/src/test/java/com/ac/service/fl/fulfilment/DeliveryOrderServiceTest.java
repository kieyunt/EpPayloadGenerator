package com.ac.service.fl.fulfilment;

import junit.framework.TestCase;

public class DeliveryOrderServiceTest extends TestCase {

	private DeliveryOrderService deliveryOrderService;
	
	@Override
	protected void setUp() throws Exception{
		deliveryOrderService = new DeliveryOrderService();
	}
	
	@Override
	protected void tearDown() throws Exception {
		deliveryOrderService = null;
	}
	
	public void testGenerateDeliveryOrderPayload() throws Exception {
		deliveryOrderService.generateDeliveryOrderPayload("00000000641400014");
		assertTrue(true);
	}
}
