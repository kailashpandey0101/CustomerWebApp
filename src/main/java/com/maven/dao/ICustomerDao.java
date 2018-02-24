package com.maven.dao;

import com.maven.entity.Customer;

public interface ICustomerDao {
	boolean addCustomer(Customer customer);
	Customer loadCustomer(long id);
	void updateCustomer(Customer customer);
	void deleteCustomer(long id);
	
}
