package com.ac.model.dao.pm;

import java.util.List;

import com.ac.model.pm.PmAddressType;

import junit.framework.TestCase;

public class AddressTypeDAOTest extends TestCase {

	AddressTypeDAO addressTypeDAO; 
	
	@Override
	protected void setUp() throws Exception{
		addressTypeDAO = new AddressTypeDAO();
	}
	
	@Override
	protected void tearDown() throws Exception {
		addressTypeDAO = null;
	}
	
	public void testRetrieveAddressType() {
		List<PmAddressType> addressTypeList = addressTypeDAO.retrieveAddressType("R", 55432l);
		System.out.println("Object : "+addressTypeList);
		if(addressTypeList!=null) {
			for(PmAddressType addressType : addressTypeList) {
				System.out.println(addressType.getAddressTypeId()+"|"+addressType.getAddressType()+"|"+addressType.getPmUser().getUserId());
			}
		}
		assertTrue(addressTypeList!=null);
	}
	
}
