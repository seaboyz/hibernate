package com.webdev.dao;

import com.webdev.utils.HibernateTestUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerDaoTest {
    private static SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;
    private CustomerDao customerDao;

    @BeforeAll
    public static void beforeTests() {
        sessionFactory = HibernateTestUtil.getSessionFactory();
    }

    @BeforeEach
    public void setup() {

        session = sessionFactory.openSession();
        customerDao = new CustomerDao(session);
        transaction = session.beginTransaction();
        System.out.println(session.isConnected());
    }

    @AfterEach
    public void tearDown() {
        transaction.rollback();
        session.close();
        System.out.println(session.isConnected());
    }

    @Test
    void testAdd() {

    }

    @Test
    void testDelete() {

    }

    @Test
    void testGet() {

    }

    @Test
    void testGetAll() {

    }

    @Test
    void testUpdate() {

    }
}
