package com.itheima.demo.utils;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static Configuration config;
    public static SessionFactory sessionFactory;
    public static Session currentSession;

    static {
        config = new Configuration().configure();
        sessionFactory = config.buildSessionFactory();
    }

    public static Session openSession() {
        return sessionFactory.openSession();
    }

    public static Session currentSession() {
        if (currentSession == null) {
            return sessionFactory.getCurrentSession();
        } else {
            return currentSession;
        }
    }

    public static void beginTransaction() {
        if (currentSession == null) {
            sessionFactory.getCurrentSession().getTransaction().begin();
        } else {
            currentSession.getTransaction().begin();
        }
    }

    public static void commit() {
        if (currentSession == null) {
            sessionFactory.getCurrentSession().getTransaction().commit();
        } else {
            currentSession.getTransaction().commit();
        }
    }

}
