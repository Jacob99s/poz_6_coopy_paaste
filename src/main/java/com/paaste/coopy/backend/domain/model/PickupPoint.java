package com.paaste.coopy.backend.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PickupPoint {

    public int id;
    public String name;
    public Coordinate coordinates;
    public String brandKey;
}
