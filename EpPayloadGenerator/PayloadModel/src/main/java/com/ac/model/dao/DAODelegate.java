package com.ac.model.dao;

import java.util.HashMap;
import java.util.Map;

public class DAODelegate {

	private static DAODelegate instance;
	private static Map<String, GenericDAO> DAOMap = new HashMap<String, GenericDAO>();
	
	public static DAODelegate getInstance() {
		if(instance == null) {
			instance = new DAODelegate();
		}
		return instance;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends GenericDAO> T getDataObject(Class<T> argClazz) {
		String argName = argClazz.getName();
		T genericDAO = (T)DAOMap.get(argName);
		
		if(genericDAO==null) {
			try {
				genericDAO = argClazz.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
			DAOMap.put(argName, genericDAO);
		}
		return genericDAO;
	}
	
}
