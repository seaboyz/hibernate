package com.webdev.dao;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.UUID;

import com.webdev.model.Customer;
import com.webdev.utils.HibernateTestUtil;

import org.hibernate.PropertyValueException;
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
    void shouldAdd() {
        Customer customer = new Customer();
        assertThrows(Exception.class, () -> customerDao.add(customer));
        Customer validatCustomer = new Customer(
                "username",
                "email",
                "password",
                "phoneNumber");
        assert (customerDao.add(validatCustomer).isPresent());

    }

    @Test
    void shouldNotAddEmp() {
        Customer customer = new Customer();
        assertThrows(PropertyValueException.class, () -> customerDao.add(customer));
    }

    @Test
    void shouldDelete() {
        Customer customer = new Customer();
        customer.setId(UUID.randomUUID());
        customer.setUsername("username");
        customer.setEmail("email");
        customer.setPassword("password");
        customer.setPhoneNumber("phoneNumber");
        customerDao.add(customer);
        customerDao.delete(customer.getId());
        assert (!customerDao.getById(customer.getId()).isPresent());
    }

    @Test
    void shouldGetCustomerById() {
        Customer customer = new Customer();
        customer.setId(UUID.randomUUID());
        customer.setUsername("username");
        customer.setEmail("email");
        customer.setPassword("password");
        customer.setPhoneNumber("phoneNumber");
        customerDao.add(customer);
        assert (customerDao.getById(customer.getId()).isPresent());
    }

    @Test
    void shouldGetListOfCustomers() {
        Customer customer = new Customer();
        customer.setId(UUID.randomUUID());
        customer.setUsername("username");
        customer.setEmail("email");
        customer.setPassword("password");
        customer.setPhoneNumber("phoneNumber");
        customerDao.add(customer);
        assert (customerDao.getAll().size() == 1);
        assert (customerDao.getAll().get(0).getId().equals(customer.getId()));
        assertEquals(ArrayList.class, customerDao.getAll().getClass());

    }

    @Test
    void testUpdate() {
        Customer customer = new Customer();
        customer.setId(UUID.randomUUID());
        customer.setUsername("username");
        customer.setEmail("email");
        customer.setPassword("password");
        customer.setPhoneNumber("phoneNumber");
        customerDao.add(customer);
        customer.setUsername("newUsername");
        customerDao.update(customer);
        assertEquals(customer.getUsername(), customerDao.getById(customer.getId()).get().getUsername());
    }
}
