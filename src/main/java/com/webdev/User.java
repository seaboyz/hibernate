package com.webdev;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public @Data class User {
    private @Getter @Setter String username;
    private @Getter @Setter String password;
    private @Getter @Setter String email;
    private @Getter @Setter String firstName;
    private @Getter @Setter String lastName;
    private @Getter @Setter String phoneNumber;
    private @Getter @Setter String address;
    private @Getter @Setter String city;
    private @Getter @Setter String state;
    private @Getter @Setter String zip;
}

