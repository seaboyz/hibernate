package com.webdev.dao;

import static org.junit.Assert.assertNotNull;

import com.webdev.model.Customer;
import com.webdev.utils.HibernateUtil;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CustomerDaoTest {
    private static SessionFactory sessionFactory;
    private static CustomerDao customerDao;

    @BeforeAll
    public static void init() {
        sessionFactory = HibernateUtil.getSessionFactory();
        customerDao = new CustomerDao(sessionFactory);
    }

    @Test
    void testAdd() {
        Customer customer = new Customer(
                "username1",
                "email1",
                "password",
                "phoneNumber");

        assertNotNull(customerDao.add(customer));
    }

    @Test
    void testGet() {
        Customer customer = new Customer(
                "username2",
                "email2",
                "password",
                "phoneNumber");

        customerDao.add(customer);

        assertNotNull(customerDao.get(customer.getId()));

    }

    @Test
    void testGetAll() {
        Customer customer = new Customer(
                "username3",
                "email3",
                "password",
                "phoneNumber");

        customerDao.add(customer);

        assert customerDao.getAll().size() == 1;

    }

    @Test
    void testUpdate() {
        Customer customer = new Customer(
                "username4",
                "email4",
                "password",
                "phoneNumber");

        customerDao.add(customer);

        customer.setEmail("email2");

        assertNotNull(customerDao.update(customer));

    }

    @Test
    void testDelete() {
        Customer customer = new Customer(
                "username5",
                "email5",
                "password",
                "phoneNumber");

        customerDao.add(customer);

        customerDao.delete(customer.getId());

        assert customerDao.getAll().size() == 0;

    }
}
