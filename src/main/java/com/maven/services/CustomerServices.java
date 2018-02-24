package com.maven.services;

import com.maven.dao.CustomerDao;
import com.maven.dao.ICustomerDao;
import com.maven.entity.Customer;

public class CustomerServices implements ICustomerServices {
	
	ICustomerDao customerDao=new CustomerDao();
	public boolean addCustomer(Customer customer) {
		
		return(customerDao.addCustomer(customer));

	}

	public Customer loadCustomer(long id) {
		
		return (customerDao.loadCustomer(id));
	}

	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);

	}

	public void deleteCustomer(long id) {
		customerDao.deleteCustomer(id);

	}

}
