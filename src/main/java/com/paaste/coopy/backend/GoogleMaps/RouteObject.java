package com.paaste.coopy.backend.GoogleMaps;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

public class RouteObject implements Serializable
{
    public List<Route> elements;
}
