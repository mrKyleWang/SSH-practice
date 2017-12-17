package com.itheima.oneToMany.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Kyle.Wang
 * 2017/12/17 0017 11:33
 */
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
