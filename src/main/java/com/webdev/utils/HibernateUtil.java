package com.webdev.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil // Hibernate utility class
{
  private static SessionFactory sessionFactory;

  private static Session session;

  private HibernateUtil() {
  }

  public static SessionFactory getSessionFactory() {
    if (sessionFactory == null) {
      sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    return sessionFactory;
  }

  public static Session getSession() {
    if (session == null) {
      session = getSessionFactory().openSession();
    }
    return session;
  }

  public static void closeSession(Session session) {
    if (session != null) {
      session.close();
    }
  }

  public static void closeSessionFactory() {
    if (sessionFactory != null) {
      sessionFactory.close();
    }
  }
}
