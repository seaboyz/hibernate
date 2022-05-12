package com.webdev.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateManager // Hibernate utility class
{
  private static final SessionFactory sessionFactory;

  static { // create sessionFactory only once
    try {
      // creating the SessionFactory from hibernate.cfg.xml
      sessionFactory = new Configuration().configure().buildSessionFactory();
    } catch (Throwable ex) {
      System.err.println("SessionFactory initial creation error." + ex);
      throw new ExceptionInInitializerError(ex);
    }
  }

  public static SessionFactory getSessionFactory() {
    return sessionFactory;
  }

  public static Session getSession() {
    return sessionFactory.openSession();
  }

  public static void closeSession(Session session) {
    if (session != null) {
      session.close();
    }
  }
}
