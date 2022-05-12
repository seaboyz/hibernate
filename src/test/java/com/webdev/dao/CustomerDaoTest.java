package com.webdev.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import com.webdev.model.Customer;
import com.webdev.utils.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerDaoTest {
    private CustomerDao customerDao;
    private Customer customer;
    private Session session;

    @BeforeEach
    public void init() {

        // get a sessionFactory
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        // get a session
        session = sessionFactory.openSession();

        customerDao = new CustomerDao(session);

        customer = new Customer(
                "John Doe",
                "john@example.com",
                "password",
                "123-456-7890");
    }

    @AfterEach
    public void tearDown() {
        session.close();
    }

    @Test
    void testAdd() {
        assertEquals(Optional.class, customerDao.add(customer));
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
