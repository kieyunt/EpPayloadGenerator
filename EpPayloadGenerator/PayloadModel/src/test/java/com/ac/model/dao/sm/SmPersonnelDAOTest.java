package com.ac.model.dao.sm;

import java.util.List;

import com.ac.model.sm.SmPersonnel;

import junit.framework.TestCase;

public class SmPersonnelDAOTest extends TestCase {

	SmPersonnelDAO personnelDAO; 
	
	@Override
	protected void setUp() throws Exception{
		personnelDAO = new SmPersonnelDAO();
	}
	
	@Override
	protected void tearDown() throws Exception {
		personnelDAO = null;
	}
	
	public void testRetrieveSmPersonnel() {
		List<SmPersonnel> personnelList = personnelDAO.retrieveSmPersonnel(49320l);
		System.out.println("Object : "+personnelList);
		if(personnelList!=null) {
			for(SmPersonnel personnel : personnelList) {
				System.out.println(personnel.getPersonnelId()+"|"+personnel.getPmUser().getUserName()+"|"+personnel.getPmUser().getDesignation());
			}
		}
		assertTrue(personnelList!=null);
	}
	
}
