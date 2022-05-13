package com.webdev.dao;

import java.io.Serializable;
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
    public Optional<Customer> add(Customer customer) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Serializable id = session.save(customer);
        session.getTransaction().commit();
        session.close();

        if (id != null) {
            return Optional.of(customer);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Customer> getById(UUID id) {
        Session session = sessionFactory.openSession();
        return Optional.ofNullable(session.get(Customer.class, id));
    }

    @Override
    public List<Customer> getAll() {
        Session session = sessionFactory.openSession();
        return session.createQuery("from Customer", Customer.class).list();
    }

    @Override
    public Customer update(Customer customer) {
        Session session = sessionFactory.openSession();
        session.update(customer);
        return session.get(Customer.class, customer.getId());
    }

    @Override
    public void delete(UUID id) {
        Session session = sessionFactory.openSession();
        session.delete(getById(id).get());
    }

    @Override
    public void delete(Customer customer) {

    }

}
