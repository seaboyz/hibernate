package com.webdev;

import java.util.UUID;

import com.webdev.model.Address;
import com.webdev.model.Cart;
import com.webdev.model.Customer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
        public static void main(String[] args) {

                // configure the database
                Configuration config = new Configuration();

                // if no configuration file is found, use the default
                // config.configure("hibernate.cfg.xml");
                config.configure();

                // build the session factory
                SessionFactory sessionFactory = config.buildSessionFactory();

                // get the session
                Session session = sessionFactory.openSession();

                // start a transaction
                session.beginTransaction();

                // create a new user
                Customer customer = new Customer(
                                "John Doe",
                                "john@example.com",
                                "password",
                                "123-456-7890");

                // create a new address

                Address address = new Address(
                                "123 Main St",
                                "Apt. 1",
                                "Anytown",
                                "CA",
                                "90210",
                                "USA");

                // save the address
                session.save(address);

                // add the address to the user
                customer.addAddress(address);

                // add another address
                Address address2 = new Address(
                                "456 Main St",
                                "",
                                "AnyCity",
                                "TX",
                                "78610",
                                "USA");

                // save the address
                session.save(address2);

                // add the address to the customer
                customer.addAddress(address2);

                // create a new cart
                Cart cart = new Cart();

                // set the cart for the customer
                customer.setCart(cart);

                // save the cart
                session.save(cart);

                // save the user
                session.save(customer);

                // commit the transaction
                session.getTransaction().commit();

                // close the session
                session.close();

                // start a new session
                session = sessionFactory.openSession();

                // get customer id
                UUID id = customer.getId();

                // get the customer by id 1
                customer = session.get(Customer.class, id);

                // print the customer
                System.out.println(customer);

                // close the session
                session.close();

        }
}
