package com.webdev;

import com.webdev.model.Cart;
import com.webdev.model.Customer;
import com.webdev.model.Product;

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

                // create a new cart
                Cart cart = new Cart();

                // set the cart for the customer
                customer.setCart(cart);

                // create a new product
                Product product = new Product(
                                "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
                                "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
                                109.95,
                                "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
                                "men's clothing");

                cart.addProduct(product,2);


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

                // save the cart
                session.save(cart);

                // save the product
                session.save(product);

                // commit the transaction
                session.getTransaction().commit();

                // close the session
                session.close();

                // * end of the hibernate code >>>

        }
}
