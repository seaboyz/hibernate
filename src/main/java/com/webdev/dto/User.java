package com.webdev.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
// singular table name
// @Table(name = "[user]")
// plural table name
@Table(name = "users")
public @Data class User {
    @Id
    private @Getter @Setter int id;
    private @Getter @Setter String username;
    private @Getter @Setter String password;
    @Column(name="")
    private @Getter @Setter String email;
    @Column(name = "first_name")
    private @Getter @Setter String firstName;
    @Column(name = "last_name")
    private @Getter @Setter String lastName;
    @Column(name = "phone_number")
    private @Getter @Setter String phoneNumber;
    private @Getter @Setter String address;
    private @Getter @Setter String city;
    private @Getter @Setter String state;
    private @Getter @Setter String zip;
}
