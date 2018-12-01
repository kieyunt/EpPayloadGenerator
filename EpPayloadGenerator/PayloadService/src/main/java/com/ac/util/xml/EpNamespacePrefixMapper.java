package com.ac.util.xml;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

public class EpNamespacePrefixMapper extends NamespacePrefixMapper {
	
	private static Map<String, String> namespaceMap = null;

	@Override
	public String getPreferredPrefix(String namespaceUri, String suggestion,
			boolean requirePrefix) {
		String prefix = "";
		if (null == namespaceMap) {
			initEpNameSapces();
		}
		for (Entry<String, String> namespaceEntry : namespaceMap.entrySet()) {
			if (namespaceEntry.getKey().equals(namespaceUri)) {
				prefix = namespaceEntry.getValue();
				break;
			}
		}
		return prefix;
	}

	/**
	 * 
	 */
	public static void initEpNameSapces() {
		namespaceMap = new HashMap<String, String>();
		namespaceMap.put("http://xmlns.oracle.com/bpm/bpmobject/Data/Order/FL_Order_Data","order");
		namespaceMap.put("http://xmlns.oracle.com/bpm/bpmobject/Data/FL_User_Data","user");
		//namesapceMap.put("http://xmlns.oracle.com/bpm/bpmobject/Data/DoFulfillment/FL_DeliveryOrder_Data", "do");
		
		namespaceMap.put("http://xmlns.oracle.com/bpm/bpmobject/Data/Common/FL_ChargeLine_Item","lineItem");
		namespaceMap.put("http://xmlns.oracle.com/bpm/bpmobject/Data/Common/FL_Bank_Details_Data", "bank");
		namespaceMap.put("http://xmlns.oracle.com/bpm/bpmobject/Data/Common/FL_Factoring_Company_Data", "fc");
		namespaceMap.put("http://xmlns.oracle.com/bpm/bpmobject/Data/Common/FL_Item_Data", "item");
		namespaceMap.put("http://xmlns.oracle.com/bpm/bpmobject/Data/InvoicePayment/FL_Deduction_Penalty_Data", "penalty");
		namespaceMap.put("http://xmlns.oracle.com/bpm/bpmobject/Data/InvoicePayment/FL_Payment_Data", "payment");
		namespaceMap.put("http://xmlns.oracle.com/bpm/bpmobject/Data/Cancel/FL_Order_Cancel_Req", "cancelOrder");
		namespaceMap.put("http://xmlns.oracle.com/bpm/bpmobject/Data/Cancel/FL_DO_Fulfillment_Cancel_Req", "cancelDO");
		namespaceMap.put("http://xmlns.oracle.com/bpm/bpmobject/Data/PHIS/CO/FL_Phis_ChargeLine_Address_Data", "PhisChargeLineAddress");
		
	}

}
