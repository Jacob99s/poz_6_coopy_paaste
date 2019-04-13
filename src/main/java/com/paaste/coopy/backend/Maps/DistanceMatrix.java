package com.paaste.coopy.backend.Maps;

import java.io.Serializable;
import java.util.List;

public class DistanceMatrix implements Serializable {
    public String status;
    public List<String> origin_addresses;
    public List<String> destination_addresses;
    public List<Route> rows;
}
