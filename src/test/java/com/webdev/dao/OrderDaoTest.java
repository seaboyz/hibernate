package com.webdev.dao;

import java.util.HashSet;
import java.util.Set;

import com.webdev.model.Customer;
import com.webdev.model.Order;
import com.webdev.model.OrderItem;
import com.webdev.model.Product;
import com.webdev.model.ShippingAddress;
import com.webdev.utils.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderDaoTest {
    private static SessionFactory sessionFactory;
    private Session session;
    private static OrderDao orderDao;

    @BeforeAll
    public static void setUp() {
        sessionFactory = HibernateUtil.getSessionFactory();
        orderDao = new OrderDao(sessionFactory);
    }

    @BeforeEach
    public void openSession() {
        session = sessionFactory.openSession();
        Customer customer = new Customer(
                "username1",
                "email1",
                "password",
                "phoneNumber");
        ShippingAddress shippingAddress = new ShippingAddress(
                "firstname",
                "lastname",
                "street",
                "street2",
                "city",
                "state",
                "zip",
                "country");
        Product product = new Product(
                "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
                "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
                109.95,
                "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
                "men's clothing");

        OrderItem orderItem = new OrderItem(product, 1);

        Set<OrderItem> orderItemList = new HashSet<>();
        orderItemList.add(orderItem);

        Order order = new Order(customer, shippingAddress, orderItemList);
        
        session.beginTransaction();
        session.save(customer);
        session.save(order);
        // the orderItemList is saved automatically, because the cascade type is ALL
        session.getTransaction().commit();
        session.close();

    }

    @Test
    void testAdd() {

    }

    @Test
    void testGet() {

    }

}
