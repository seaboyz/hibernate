package com.webdev.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.webdev.model.Customer;
import com.webdev.utils.HibernateManager;

import org.hibernate.Session;

import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerDaoTest {
    private CustomerDao customerDao;
    private Customer customer;
    private Session session;

    @BeforeEach
    public void init() {

        session = HibernateManager.getSession();
        customerDao = new CustomerDao(session);
        customer = new Customer(
                "John Doe",
                "john@example.com",
                "password",
                "123-456-7890");
    }

    @AfterEach
    public void tearDown() {
        HibernateManager.closeSession(session);
    }

    @Test
    void testAdd() {
        assertNotNull(customerDao.add(customer));
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
