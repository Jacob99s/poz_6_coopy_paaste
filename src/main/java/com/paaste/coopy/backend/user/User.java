package com.paaste.coopy.backend.user;


public class User {

    private long id;
    private HomeAddress homeAddress;
    private PreferredPickupPlace preferredPickupPlace;

    public User(long id, HomeAddress homeAddress, PreferredPickupPlace preferredPickupPlace) {
        this.id = id;
        this.homeAddress = homeAddress;
        this.preferredPickupPlace = preferredPickupPlace;
    }

    public HomeAddress getHomeAddress() {
        return homeAddress;
    }

    public PreferredPickupPlace getPreferredPickupPlace() {
        return preferredPickupPlace;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", homeAddress=" + homeAddress +
                ", preferredPickupPlace=" + preferredPickupPlace +
                '}';
    }
}
