package com.webdev.service;

import com.webdev.dao.AddressDao;
import com.webdev.dao.CustomerDao;
import com.webdev.dao.OrderDao;
import com.webdev.dao.OrderItemDao;
import com.webdev.dao.ProductDao;

public class OrderService {
    private AddressDao addressDao;
    private CustomerDao customerDao;
    private OrderDao orderDao;
    private ProductDao productDao;
    private OrderItemDao orderItemDao;

    public OrderService(AddressDao addressDao, CustomerDao customerDao, OrderDao orderDao, ProductDao productDao,
            OrderItemDao orderItemDao) {
        this.addressDao = addressDao;
        this.customerDao = customerDao;
        this.orderDao = orderDao;
        this.productDao = productDao;
        this.orderItemDao = orderItemDao;
    }

    // public placeAOrder(Integer customerId, Integer addressId)
}
