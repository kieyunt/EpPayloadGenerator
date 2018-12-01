package com.ac.model.dao.sm;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.ac.model.dao.GenericDAO;
import com.ac.model.sm.SmPersonnel;

public class SmPersonnelDAO extends GenericDAO {

	@SuppressWarnings("unchecked")
	public List<SmPersonnel> retrieveSmPersonnel(Long supplierId) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Query<SmPersonnel> query = session.createQuery("from SmPersonnel e where e.smAppl.applId=e.smAppl.smSupplier.smAppl.applId and e.recordStatusFlg=1 and e.pmUser is not null and e.smAppl.smSupplier.supplierId = :supplierId ");
		query.setParameter("supplierId", supplierId);
		List<SmPersonnel> personnelList = query.list();
		session.getTransaction().commit();
		return personnelList;
	}		
	
}
