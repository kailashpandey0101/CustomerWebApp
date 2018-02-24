package com.maven.utils;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {

	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static ServiceRegistry serviceRegistry;
	final static Logger logger=Logger.getLogger(HibernateUtils.class);
	private static SessionFactory buildSessionFactory() {
		try {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties());
			SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
			return sessionFactory;
		} catch (Throwable ex) {
			logger.error("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		logger.info("creating a new session");
		return sessionFactory;
	}
}
