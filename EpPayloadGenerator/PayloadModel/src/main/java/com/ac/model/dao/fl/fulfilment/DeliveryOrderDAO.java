package com.ac.model.dao.fl.fulfilment;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.ac.model.dao.GenericDAO;
import com.ac.model.fl.fulfilment.FlDeliveryOrder;

public class DeliveryOrderDAO extends GenericDAO {

	@SuppressWarnings("unchecked")
	public FlDeliveryOrder retrieveDeliveryOrderById(Long deliveryOrderId) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Query<FlDeliveryOrder> query = session.createQuery("from FlDeliveryOrder e where e.deliveryOrderId = :deliveryOrderId ");
		query.setParameter("deliveryOrderId", deliveryOrderId);
		List<FlDeliveryOrder> flDeliveryOrders = query.list();
		session.getTransaction().commit();
		if(!flDeliveryOrders.isEmpty())
			return flDeliveryOrders.get(0);
		else 
			return null;
	}
	
}
