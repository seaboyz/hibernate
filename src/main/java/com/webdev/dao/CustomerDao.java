package com.webdev.dao;

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
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
        if (customer.getId() != null) {
            return Optional.of(customer);
        }
        return Optional.empty();

    }

    @Override
    public Optional<Customer> getById(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<Customer> getAll() {
        return null;
    }

    @Override
    public Customer update(Customer customer) {
        return null;
    }

    @Override
    public void delete(Customer customer) {
        session.beginTransaction();
        session.delete(customer);
        session.getTransaction().commit();
    }

}
