package com.ac.model.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public abstract class GenericDAO {

	private static SessionFactory sessionFactory;
	
	protected SessionFactory getSessionFactory() {
		if(sessionFactory==null) {
			final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
			try {
				sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			} catch (Exception e) {
				e.printStackTrace();
				StandardServiceRegistryBuilder.destroy(registry);
			}
		}
		return sessionFactory;
	}
	
	protected void clearSessionFactory() {
		if(sessionFactory!=null) {
			sessionFactory.close();
		}
	}
	
}
