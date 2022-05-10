package com.webdev.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

    // * <<< many-to-many relationship with product
    @ManyToMany
    @JoinTable(name = "order_item", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products = new ArrayList<Product>();

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void addProduct(Product product, int quantity) {
        for (int i = 0; i < quantity; i++) {
            products.add(product);
        }
    }
    // * end of many-to-many relationship with product >>>

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
