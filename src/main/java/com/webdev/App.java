package com.webdev;

import com.webdev.dto.User;

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
        User user = new User(
                "John Doe",
                "john@example.com",
                "password",
                "123-456-7890");

        // save the user
        session.save(user);

        // commit the transaction
        session.getTransaction().commit();

        // close the session
        session.close();

    }
}
