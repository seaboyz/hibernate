package com.webdev;

import com.webdev.dto.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class App {
    public static void main(String[] args) {
        // Create a new user
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setUsername("test");
        user.setPassword("123456");
        user.setEmail("test@test.com");
        user.setPhoneNumber("5555555555");
        user.setAddress("123 Main St");
        user.setCity("Anytown");
        user.setState("TX");
        user.setZip("12345");

        // create a session factory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

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
