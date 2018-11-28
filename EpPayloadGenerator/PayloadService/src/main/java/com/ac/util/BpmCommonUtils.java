package com.ac.util;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class BpmCommonUtils {

	public static Calendar getCalendarValue(Date date){
		Calendar cal=Calendar.getInstance();
		cal.setTime(date);
		if(cal.get(Calendar.MILLISECOND)==0) {
			cal.set(Calendar.MILLISECOND, 1);
		}
		return cal;
	}

	public static List<?> limitAssigneeSize(List<?> assigneeList) {
		if(assigneeList.size()>70) {
			Collections.shuffle(assigneeList);
			assigneeList = assigneeList.subList(0, 70);
		}
		return assigneeList;
	}
	
	// This method also used in DeliveryOrderSO to trim the Supplier DO Reference Number
	public static String trimUserNameAsIDD(String userName) {
		if(userName!=null && userName.length()>30) {
			userName = userName.substring(0, 30);
		}
		return userName;
	}
	
	public static String trimDesignationAsIDD(String designation) {
		if(designation!=null && designation.length()>40) {
			designation = designation.substring(0, 40);
		}
		return designation;
	}
}
