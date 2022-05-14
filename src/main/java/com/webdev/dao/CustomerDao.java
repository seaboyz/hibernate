package com.webdev.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.webdev.model.Customer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CustomerDao implements Dao<Customer> {

    SessionFactory sessionFactory;

    public CustomerDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Customer add(Customer customer) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(customer);
        session.getTransaction().commit();
        session.close();
        return customer;

    }

    @Override
    public Optional<Customer> get(UUID id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Optional<Customer> customer = Optional.ofNullable(session.get(Customer.class, id));
        session.getTransaction().commit();
        session.close();
        return customer;
    }

    @Override
    public List<Customer> getAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Customer> customers = session.createQuery("from Customer", Customer.class).list();

        session.getTransaction().commit();
        session.close();
        return customers;
    }

    @Override
    public Customer update(Customer customer) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Customer customerToUpdate = session.get(Customer.class, customer.getId());

        session.evict(customerToUpdate);

        customerToUpdate.setUsername(customer.getUsername());
        customerToUpdate.setEmail(customer.getEmail());
        customerToUpdate.setPassword(customer.getPassword());
        customerToUpdate.setPhoneNumber(customer.getPhoneNumber());

        session.merge(customerToUpdate);

        session.getTransaction().commit();
        session.close();
        return customerToUpdate;
    }

    @Override
    public void delete(UUID id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Customer customer = session.get(Customer.class, id);
        session.delete(customer);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Customer t) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(t);
        session.getTransaction().commit();
        session.close();
    }
}
