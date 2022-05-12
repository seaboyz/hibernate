package com.webdev.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "orders")
public class Order {

    @Id // primary key
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private Set<OrderItem> orderDetails = new HashSet<OrderItem>();

    // shipping address
    @Embedded
    private Address shippingAddress;

    // todo: implement payment_method

    private double total;

    public Order(Customer customer, Address shippingAddress, double total) {
        this.customer = customer;
        this.shippingAddress = shippingAddress;
        this.total = total;
    }

    public UUID getId() {
        return id;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Set<OrderItem> getOrderDetails() {
        return orderDetails;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void addProduct(Product product, int quantity) {
        OrderItem orderDetail = new OrderItem(product, this, quantity, product.getPrice() * quantity);
        orderDetails.add(orderDetail);
        total += orderDetail.getSubtotal();
    }

}
