package com.webdev.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

    // * <<< one-to-many relationship with order status
    @OneToMany(mappedBy = "order")
    private OrderStatus status;

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
    // * end of one-to-many relationship with order status >>>

    // * <<< one-to-one relationship with order_detail
    @OneToOne(mappedBy = "order")
    private OrderDetail orderDetail;

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    // * end of one-to-one relationship with order_detail >>>

    // * <<< many-to-many relationship with order
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    // * end of many-to-many relationship with order >>>

    // * end of one-to-one relationship with order_detail >>>

    // * <<< one-to-one relationship with shipment
    // TODO: implement shipment
    // * end of one-to-one relationship with shipment >>>

    // * <<< one-to-one relationship with payment_method
    // TODO: implement payment_method
    // * end of one-to-one relationship with payment_method >>>


    

}
