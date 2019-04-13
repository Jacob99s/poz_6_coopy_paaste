package com.paaste.coopy.backend.domain.model;

import com.paaste.coopy.backend.user.Address;

public class PickupPlace {

    private String name;
    private Address address;

    public PickupPlace(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "PickupPlace{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
