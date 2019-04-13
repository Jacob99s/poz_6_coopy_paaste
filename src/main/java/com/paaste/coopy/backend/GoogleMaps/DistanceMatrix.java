package com.paaste.coopy.backend;

import java.io.Serializable;
import java.util.List;

public class DistanceMatrix implements Serializable {
    public List<String> origin_addresses;
    public List<String> destination_addresses;
    public List<Object> rows;

}
