package com.paaste.coopy.backend.GoogleMaps;

public interface GoogleMaps {
    DistanceMatrix getDistanceMatrix(GeoCoords origin, GeoCoords destination);
}
