package com.webdev.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	private HibernateUtil() {
	}

	// configure hibernate session factory and session
	// using default xml configuration file
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {

			// first way - hibernate.cfg.xml
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

			// second way - hibernate.properties
			// try {
			// Configuration configuration = new Configuration();
			// Properties properties = getProperties();
			// configuration.setProperties(properties);
			// configuration.addAnnotatedClass(com.webdev.model.Customer.class);
			// configuration.addAnnotatedClass(com.webdev.model.Address.class);
			// configuration.addAnnotatedClass(com.webdev.model.Order.class);
			// configuration.addAnnotatedClass(com.webdev.model.Product.class);
			// configuration.addAnnotatedClass(com.webdev.model.OrderItem.class);
			// configuration.addAnnotatedClass(com.webdev.model.CartItem.class);
			// } catch (IOException e) {
			// e.printStackTrace();
			// }

		}
		return sessionFactory;
	}

	public static void closeSessionFactory() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}

	// private static Properties getProperties() throws IOException {
	// // load a properties file for testing purpose
	// // using h2 database
	// Properties properties = new Properties();
	// URL propertiesURL = Thread.currentThread()
	// .getContextClassLoader()
	// .getResource("hibernateTest.properties");
	// try (FileInputStream inputStream = new
	// FileInputStream(propertiesURL.getFile())) {
	// properties.load(inputStream);
	// }
	// return properties;
	// }

}
