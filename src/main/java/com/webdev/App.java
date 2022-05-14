package com.webdev;

import com.webdev.dao.CustomerDao;
import com.webdev.model.Customer;
import com.webdev.utils.HibernateUtil;

import org.hibernate.SessionFactory;

public class App {
	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		CustomerDao customerDao = new CustomerDao(sessionFactory);

		Customer customer = new Customer(
				"username",
				"email",
				"password",
				"phoneNumber");

		customerDao.add(customer);

		customer.setEmail("email2");

		customerDao.update(customer);

		
	}
}