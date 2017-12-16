package com.itheima.demo.utils;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static Configuration config;
	public static SessionFactory sessionFactory;

	static {
		config = new Configuration().configure();
		sessionFactory = config.buildSessionFactory();
	}

	public static Session openSession() {
		return sessionFactory.openSession();
	}

}
