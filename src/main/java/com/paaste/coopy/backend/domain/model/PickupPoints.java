package com.paaste.coopy.backend.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PickupPoints {

    private List<PickupPoint> points;

    public List<PickupPoint> getPoints() {
        return points;
    }

    public void setPoints(List<PickupPoint> points) {
        this.points = points;
    }
}
