package com.ac.model.dao.pm;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.ac.model.dao.GenericDAO;
import com.ac.model.pm.PmAddressType;

public class AddressTypeDAO extends GenericDAO {

	@SuppressWarnings("unchecked")
	public List<PmAddressType> retrieveAddressType(String addressType, Long addressId) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Query<PmAddressType> query = session.createQuery("from PmAddressType e where e.addressType = :addressType and e.pmAddressId = :pmAddressId ");
		query.setParameter("addressType", addressType);
		query.setParameter("pmAddressId", addressId);
		List<PmAddressType> addressTypeList = query.list();
		session.getTransaction().commit();
		return addressTypeList;
	}		
	
}
