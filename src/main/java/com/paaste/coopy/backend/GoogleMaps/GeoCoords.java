package com.paaste.coopy.backend.GoogleMaps;

import com.paaste.coopy.backend.domain.model.Coordinate;

public class GeoCoords {

    public GeoCoords(double latitude, double longitude)
    {
        setCoords(latitude, longitude);
    }

    public GeoCoords(Coordinate coords)
    {
        setCoords(coords.latitude, coords.longitude);
    }

    public void setCoords(double latitude, double longitude)
    {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude()
    {
        return latitude;
    }

    public double getLongitude()
    {
        return longitude;
    }

    private double latitude;
    private double longitude;
}
