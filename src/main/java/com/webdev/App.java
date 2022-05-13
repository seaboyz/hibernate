package com.webdev;

import com.webdev.model.Customer;
import com.webdev.utils.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class App {
	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Customer customer = new Customer(
				"username",
				"email",
				"password",
				"phoneNumber");

		session.update(customer);

		// only the last change before commit is persisted to the database

		session.getTransaction().commit();
		// after commit, the customer object is saved to the database
		session.close();
		// after close, the session is closed and the session factory is closed

	}
}