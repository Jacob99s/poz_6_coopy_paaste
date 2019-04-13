package com.paaste.coopy.backend.user;

import com.paaste.coopy.backend.domain.model.PickupPlace;

public class PreferredPickupPlace {

    private PickupPlace pickupPlace;

    public PreferredPickupPlace(PickupPlace pickupPlace) {
        this.pickupPlace = pickupPlace;
    }

    public PickupPlace getPickupPlace() {
        return pickupPlace;
    }

    @Override
    public String toString() {
        return "PreferredPickupPlace{" +
                "pickupPlace=" + pickupPlace +
                '}';
    }
}
