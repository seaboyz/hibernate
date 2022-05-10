package com.webdev.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "[order]")
public class Order {

    @Id // primary key
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>();

    // todo: implement shipment

    // todo: implement payment_method

    @Column(name = "total")
    private double total;

    public Order() {
    }

    public Order(Customer customer) {
        this.customer = customer;
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

    public Set<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void addProduct(Product product, int quantity) {
        OrderDetail orderDetail = new OrderDetail(product, this, quantity, product.getPrice() * quantity);
        orderDetails.add(orderDetail);
        total += orderDetail.getSubtotal();
    }

}
