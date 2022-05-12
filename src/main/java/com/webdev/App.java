package com.webdev;

import com.webdev.model.Customer;

import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {

		try {
			// configure the database
			Configuration config = new Configuration();

			config.setProperty("connection.driver.class", "org.postgresql.Driver");
			config.setProperty("connection.url",
					"jdbc:postgresql://training-postgres.ckbqjaef5nqv.us-east-2.rds.amazonaws.com:5432/qianggao_p2?schemaName=public");
			config.setProperty("connection.username", "postgres");
			config.setProperty("connection.password", "R3vatur3!");

			// add annotated classes
			config.addAnnotatedClass(Customer.class);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
