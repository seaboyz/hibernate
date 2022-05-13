package com.webdev.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.webdev.model.Customer;

import org.hibernate.Session;

public class CustomerDao implements Dao<Customer> {

    Session session;

    public CustomerDao(Session session) {
        this.session = session;
    }

    @Override
    public Optional<Customer> add(Customer customer) {
        session.persist(customer);
        Customer savedCustomer = session.get(Customer.class, customer.getId());

        if (savedCustomer != null) {
            return Optional.of(savedCustomer);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Customer> getById(UUID id) {
        return Optional.ofNullable(session.get(Customer.class, id));
    }

    @Override
    public List<Customer> getAll() {
        return session.createQuery("from Customer", Customer.class).list();
    }

    @Override
    public Customer update(Customer customer) {
        return null;
    }

    @Override
    public void delete(UUID id) {
        session.delete(getById(id).get());
    }

    @Override
    public void delete(Customer customer) {
        session.delete(customer);
    }

}
