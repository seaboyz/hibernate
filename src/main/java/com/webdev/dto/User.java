package com.webdev.dto;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
// singular table name
// @Table(name = "[user]")
// plural table name
@Table(name = "users")
public @ToString class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

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

    @Column(name = "created_at")
    private Date createdAt;

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
        this.createdAt = new Date(System.currentTimeMillis());
    }

}
