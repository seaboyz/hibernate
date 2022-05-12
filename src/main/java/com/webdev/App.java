package com.webdev;

import java.util.Optional;

import com.webdev.dao.CustomerDao;
import com.webdev.model.CartItem;
import com.webdev.model.Customer;
import com.webdev.model.Product;
import com.webdev.utils.HibernateUtil;

import org.hibernate.Session;

public class App {
        public static void main(String[] args) {

                // * <<< the beginning of the java code

                // create a new user
                Customer customer = new Customer(
                                "John Doe",
                                "john@example.com",
                                "password",
                                "123-456-7890");

                // create a new product
                Product product1 = new Product(
                                "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
                                "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
                                109.95,
                                "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
                                "men's clothing");

                // create another new product
                Product product2 = new Product(
                                "Mens Cotton Jacket",
                                "great outerwear jackets for Spring/Autumn/Winter, made of 100% cotton",
                                55.99,
                                "https://fakestoreapi.com/img/71li-ujtlUL._AC_UX679_.jpg",
                                "men's clothing");

                // create a cartItem
                CartItem cartItem = new CartItem(product1, 1);

                // create another cartItem
                CartItem cartItem2 = new CartItem(product2, 2);

                // add the cartItem to the customer's cart
                customer.addCartItem(cartItem);
                customer.addCartItem(cartItem2);

                // * the end of the java code >>>

                // * <<< the begining of the hibernate code
                // create a new session
                Session session = HibernateUtil.getSessionFactory().openSession();

                CustomerDao customerDao = new CustomerDao(session);

                // add the customer to the database
                Optional<Customer> optionalCustomer = customerDao.add(customer);
                if (optionalCustomer.isPresent()) {
                        System.out.println("Customer added successfully");
                } else {
                        System.out.println("Customer not added");
                }

                session.delete(customer);

                session.close();

                session.getTransaction().commit();

                // * end of the hibernate code >>>

        }
}
