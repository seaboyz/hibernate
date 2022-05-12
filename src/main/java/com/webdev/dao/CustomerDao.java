package com.webdev.dao;

import java.util.List;
import java.util.Optional;

import com.webdev.model.Customer;

import org.hibernate.Session;

public class CustomerDao implements Dao<Customer> {
    private Session session;

    public CustomerDao(Session session) {
        this.session = session;
    }

    @Override
    public Customer add(Customer customer) {
        session.save(customer);
        session.getTransaction().commit();
        Customer savedCustomer = session.get(Customer.class, customer.getId());
        session.close();

        return savedCustomer;
    }

    @Override
    public Optional<Customer> get(int id) {
        return Optional.ofNullable(session.get(Customer.class, id));
    }

    @Override
    public List<Customer> getAll() {
        return session.createQuery("from Customer", Customer.class).list();
    }

    @Override
    public Customer update(Customer customer) {
        session.update(customer);
        return customer;
    }

    @Override
    public void delete(int id) {
        session.delete(get(id).get());
    }
}
