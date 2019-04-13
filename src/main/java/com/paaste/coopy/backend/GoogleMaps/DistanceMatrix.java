package com.paaste.coopy.backend.GoogleMaps;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DistanceMatrix implements Serializable {
    public String status;
    public List<String> origin_addresses;
    public List<String> destination_addresses;
    public List<RouteObject> rows;
}
