package com.paaste.coopy.backend.Pickups;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Coordinate {

    @JsonProperty(value = "lat")
    public double latitude;

    @JsonProperty(value = "lon")
    public double longitude;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return Double.compare(that.latitude, latitude) == 0 &&
                Double.compare(that.longitude, longitude) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }
}
