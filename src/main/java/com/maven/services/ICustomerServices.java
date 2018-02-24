package com.maven.services;

import com.maven.entity.Customer;

public interface ICustomerServices {
	boolean addCustomer(Customer customer);
	Customer loadCustomer(long id);
	void updateCustomer(Customer customer);
	void deleteCustomer(long id);
}
