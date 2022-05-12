package com.webdev.utils;

import com.webdev.model.ShippingAddress;

public class Address {
    public static ShippingAddress createShippingAddress(String firstName, String lastName,
            com.webdev.model.Address address) {
        return new ShippingAddress(
                firstName,
                lastName,
                address.getStreet(),
                address.getStreet2(),
                address.getCity(),
                address.getState(),
                address.getZip(),
                address.getCountry());

    }
}
