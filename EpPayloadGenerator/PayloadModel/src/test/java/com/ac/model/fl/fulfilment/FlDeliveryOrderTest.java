package com.ac.model.fl.fulfilment;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import junit.framework.TestCase;

public class FlDeliveryOrderTest extends TestCase {

	private SessionFactory sessionFactory;
	
	@Override
	protected void setUp() throws Exception{
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
	
	@Override
	protected void tearDown() throws Exception {
		if(sessionFactory!=null) {
			sessionFactory.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void testRetrieve() {
		Session session = sessionFactory.openSession();
		session = sessionFactory.openSession();
		session.beginTransaction();
		List<FlDeliveryOrder> flDeliveryOrders = session.createQuery("from FlDeliveryOrder").setMaxResults(10).list();
		flDeliveryOrders.forEach(a->System.out.println(a.getDeliveryOrderId()+"|"+a.getDeliveryOrderNo()+"|"+a.getCreatedDate()));
		session.getTransaction().commit();
		session.close();
		assertTrue(flDeliveryOrders.size()>0);
	}
}
