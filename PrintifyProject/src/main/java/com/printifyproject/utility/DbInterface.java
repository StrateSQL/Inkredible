package com.printifyproject.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DbInterface {
    private static final SessionFactory sessionFactory;

    // Static initialization block to create the SessionFactory
    static {
        try {
            // Load your Hibernate configuration (hibernate.cfg.xml or create a configuration programmatically)
            Configuration configuration = new Configuration().configure();

            // Build the SessionFactory
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Method to obtain a new Hibernate session
    public static Session openSession() {
        return sessionFactory.openSession();
    }
}

