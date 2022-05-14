package com.webdev.dao;

import static org.junit.Assert.assertNotNull;

import com.webdev.model.Customer;
import com.webdev.utils.HibernateUtil;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerDaoTest {
    private static SessionFactory sessionFactory;
    private CustomerDao customerDao;

    @BeforeAll
    public static void beforeTests() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @BeforeEach
    public void setup() {
        customerDao = new CustomerDao(sessionFactory);
    }

    @AfterEach
    public void tearDown() {
        sessionFactory.close();
    }

    @Test
    void testAdd() {
        Customer customer = new Customer(
                "username",
                "email",
                "password",
                "phoneNumber");

        assert customerDao.add(customer) != null;
    }

    @Test
    void testGet() {
        Customer customer = new Customer(
                "username",
                "email",
                "password",
                "phoneNumber");

        customerDao.add(customer);

        assert customerDao.get(customer.getId()) != null;

    }

    @Test
    void testGetAll() {
        Customer customer = new Customer(
                "username",
                "email",
                "password",
                "phoneNumber");

        customerDao.add(customer);

        assert customerDao.getAll().size() == 1;

    }

    @Test
    void testUpdate() {
        Customer customer = new Customer(
                "username",
                "email",
                "password",
                "phoneNumber");

        customerDao.add(customer);

        customer.setEmail("email2");

        assertNotNull(customerDao.update(customer));

    }

    @Test
    void testDelete() {
        Customer customer = new Customer(
                "username",
                "email",
                "password",
                "phoneNumber");

        customerDao.add(customer);

        customerDao.delete(customer.getId());

        assert customerDao.getAll().size() == 0;


    }
}
