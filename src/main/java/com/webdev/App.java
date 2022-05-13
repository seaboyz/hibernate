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

		// before save, the customer object is not associated with the session
		session.save(customer);
		// after save, the id is set, and the customer object is associated with the
		// session

		// after save, any changes to the customer object are persisted to the database
		customer.setUsername("newUsername");
		// customer.setUsername("newUsername1");
		// customer.setUsername("newUsername2");

		// only the last change before commit is persisted to the database

		session.getTransaction().commit();
		// after commit, the customer object is saved to the database
		// session.close();

	}
}