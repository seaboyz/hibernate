package com.webdev.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

    private OrderStatus status;

    // * <<< many-to-one relationship with customer
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    // * end of many-to-one relationship with customer >>>

    // * <<< one-to-one relationship with order_detail
    // todo - implement order_detail
    // * end of one-to-one relationship with order_detail >>>

    // * <<< one-to-one relationship with shipment
    // todo: implement shipment
    // * end of one-to-one relationship with shipment >>>

    // * <<< one-to-one relationship with payment_method
    // todo: implement payment_method
    // * end of one-to-one relationship with payment_method >>>

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

}
