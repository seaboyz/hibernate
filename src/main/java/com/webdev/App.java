package com.webdev;

import com.webdev.dto.Address;
import com.webdev.dto.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        /*
         * Save user to database
         */
        User user = new User(
                "test",
                "123456",
                "test@test.com",
                "John",
                "Doe",
                "5555555555",
                new Address(
                        "123 Main St",
                        "Anytown",
                        "TX",
                        "12345"));

        // Create a configuration object
        Configuration cfg = new Configuration();

        // Create a session factory object
        SessionFactory sessionFactory = cfg.configure().buildSessionFactory();

        // create a session
        Session session = sessionFactory.openSession();

        // start a transaction
        session.beginTransaction();

        // save the user
        // session.save(user) is deprecated
        session.save(user);

        // commit transaction
        session.getTransaction().commit();

        // close session
        session.close();

        /*
         * Read the user from the database
         */

        user = null;

        // create a session
        session = sessionFactory.openSession();

        // start a transaction
        session.beginTransaction();

        // retrieve the user
        user = (User) session.get(User.class, 1);

        // print the user
        System.out.println(user.getAddress().getCity());

    }
}
