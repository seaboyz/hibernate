package com.webdev;

import com.webdev.model.Customer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
        public static void main(String[] args) {

                // * <<< the beginning of the java code

                // create a new user
                Customer customer = new Customer(
                                "John Doe",
                                "john@example.com",
                                "password",
                                "123-456-7890");

                Customer customer2 = new Customer(
                                "John Gao",
                                "john@example.com",
                                "123456",
                                "555-555-5555");

                // * the end of the java code >>>

                // * <<< the begining of the hibernate code

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

                // save the customer
                session.save(customer);
                session.save(customer2);

                // commit the transaction
                session.getTransaction().commit();

                // close the session
                session.close();

                // * end of the hibernate code >>>

        }
}
