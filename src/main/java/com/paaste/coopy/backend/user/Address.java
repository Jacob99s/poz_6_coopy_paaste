package com.paaste.coopy.backend.user;

public class Address {

    private Location location;
    private String City;
    private String streetName;

    public Address(Location location, String city, String streetName) {
        this.location = location;
        City = city;
        this.streetName = streetName;
    }

    public Location getLocation() {
        return location;
    }

    public String getCity() {
        return City;
    }

    public String getStreetName() {
        return streetName;
    }

    @Override
    public String toString() {
        return "Address{" +
                "location=" + location +
                ", City='" + City + '\'' +
                ", streetName='" + streetName + '\'' +
                '}';
    }
}
