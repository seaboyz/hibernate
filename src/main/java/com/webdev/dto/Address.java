package com.webdev.dto;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable
public @NoArgsConstructor @AllArgsConstructor @ToString class Address {
    private @Getter @Setter String street;
    private @Getter @Setter String city;
    private @Getter @Setter String state;
    private @Getter @Setter String zip;
}
