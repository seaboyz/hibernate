package com.webdev.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
// singular table name
// @Table(name = "[user]")
// plural table name
@Table(name = "users")
public @Data class User {
    @Id
    private int id;
    private String username;
    private String password;
    @Column(name = "")
    private String email;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private String zip;

    public User() {
    }

    public User(int id,
            String username,
            String password,
            String email,
            String firstName,
            String lastName,
            String phoneNumber,
            String address,
            String city,
            String state,
            String zip) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

}
