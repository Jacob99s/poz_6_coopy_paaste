package com.paaste.coopy.backend.user;

public class HomeAddress {

    private Address address;
    private String buildingNumber;

    public HomeAddress(Address address, String buildingNumber) {
        this.address = address;
        this.buildingNumber = buildingNumber;
    }

    public Address getAddress() {
        return address;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }
}
