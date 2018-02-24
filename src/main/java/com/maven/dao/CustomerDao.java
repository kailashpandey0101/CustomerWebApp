package com.maven.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.maven.entity.Customer;
import com.maven.utils.HibernateUtils;



public class CustomerDao implements ICustomerDao {
	final static Logger logger=Logger.getLogger(CustomerDao.class);
	public boolean addCustomer(Customer customer) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(customer);
			transaction.commit();
			logger.info("Customer object is added to the database successfully");
			return true;
		} catch (Exception e) {
			transaction.rollback();
			logger.info("Customer object cannot be added to database");
			logger.error(e);
			return false;
		} finally {
			if (session != null)
				session.close();
			logger.info("session is closed");
		}

	}

	public Customer loadCustomer(long id) {
		logger.info("getting customer from databse");
		Session session = getSession();
		Customer customer = (Customer) session.get(Customer.class, id);
		session.close();
		logger.info("session is closed");
		return customer;

	}

	public void updateCustomer(Customer customer) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(customer);
			transaction.commit();
			logger.info("Customer object is added to the database successfully");
		} catch (Exception e) {
			transaction.rollback();
			logger.info("Customer object cannot be added to database");
			logger.error(e);
		} finally {
			if (session != null)
				session.close();
		}

	}

	public void deleteCustomer(long id) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		try {
			Customer customer = (Customer) session.get(Customer.class, id);
			session.delete(customer);
			transaction.commit();
			logger.info("Customer object is deleted to the database successfully");
		} catch (Exception e) {
			transaction.rollback();
			logger.error(e);
		} finally {
			if (session != null)
				session.close();
		}

	}


	private Session getSession() {
		return HibernateUtils.getSessionFactory().openSession();
	}

}
