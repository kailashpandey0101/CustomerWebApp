package com.maven.utils;

import java.text.ParseException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;

import com.maven.entity.Customer;

public class CustomerUtils {
	final static Logger logger=Logger.getLogger(CustomerUtils.class);
	public static Customer getCustomer(HttpServletRequest request) {
		logger.info("Getting customer info from user");
		Customer customer=new Customer();
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		Date dob=null;
		try {
			dob= DateUtils.parseDate(request.getParameter("dob"), "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String phoneNumber=request.getParameter("phoneNumber");
		String email=request.getParameter("email");
		
		customer.setDob(dob);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setPhoneNumber(phoneNumber);
		customer.setEmail(email);
		
		
		logger.info("customer object created and returned");
		return customer;
		
	}
}
