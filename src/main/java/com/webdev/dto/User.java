package com.webdev.dto;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
// singular table name
// @Table(name = "[user]")
// plural table name
@Table(name = "users")

public @NoArgsConstructor // default constructor
@RequiredArgsConstructor // constructor with @NonNull parameters
@Getter @Setter // getters and setters for all fields
class User {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // use traditional generator
    private int id;

    private @NonNull String username;

    private @NonNull String password;

    private @NonNull String email;

    @Column(name = "first_name")
    private @NonNull String firstName;

    @Column(name = "last_name")
    private @NonNull String lastName;

    @Column(name = "phone_number")
    private @NonNull String phoneNumber;

    @Embedded
    private @NonNull Address address;

}
