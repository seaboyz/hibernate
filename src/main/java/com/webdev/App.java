package com.webdev;

import com.webdev.dto.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        User user = new User(
                "test",
                "123456",
                "test@test.com",
                "John", 
                "Doe",
                "5555555555",
                "123 Main St",
                "Anytown",
                "TX",
                "12345");

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
    }
}
