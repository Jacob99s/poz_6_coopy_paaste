package com.paaste.coopy.backend.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Coordinate {

    @JsonProperty(value = "lat")
    public double latitude;

    @JsonProperty(value = "lon")
    public double longitude;
}
