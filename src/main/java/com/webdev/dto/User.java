package com.webdev.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
// singular table name
// @Table(name = "[user]")
// plural table name
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private @Getter @Setter String username;

    private @Getter @Setter String password;

    private @Getter @Setter String email;

    @Column(name = "first_name")
    private @Getter @Setter String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone_number")
    private String phoneNumber;

    private @Getter @Setter String address;

    private @Getter @Setter String city;

    private @Getter @Setter String state;

    private @Getter @Setter String zip;

    public User() {
    }

    public User(
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
