package com.webdev.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private String name;

    private String email;

    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "customer")
    private Set<Address> addresses = new HashSet<Address>();

    public void addAddress(Address address) {
        this.addresses.add(address);
        address.setCustomer(this);
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    @OneToMany(mappedBy = "customer")
    private Set<Order> orders = new HashSet<Order>();

    public Customer() {
    }

    public Customer(String name, String email, String password, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
                + ", phoneNumber=" + phoneNumber + "]";
    }

}
