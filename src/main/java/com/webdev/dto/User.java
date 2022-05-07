package com.webdev.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
// singular table name
// @Table(name = "[user]")
// plural table name
@Table(name = "users")
public @NoArgsConstructor class User {
    // primary key
    @Id
    // use UUID generator
    // @GeneratedValue(generator = "UUID")
    // @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    // use traditional generator
    @GeneratedValue
    // column name
    @Column(name = "id", updatable = false, nullable = false)
    private @Getter Integer id;

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

    @Embedded
    private @Getter @Setter Address address;

    public User(
            String username,
            String password,
            String email,
            String firstName,
            String lastName,
            String phoneNumber,
            Address address) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

}
