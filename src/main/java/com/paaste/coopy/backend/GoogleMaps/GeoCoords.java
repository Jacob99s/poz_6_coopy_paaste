package com.paaste.coopy.backend.GoogleMaps;

import com.paaste.coopy.backend.Exceptions.OutOfRangeException;

public class GeoCoords {

    public GeoCoords(double latitude, double longitude) throws OutOfRangeException
    {
        setCoords(latitude, longitude);
    }

    public void setCoords(double latitude, double longitude) throws OutOfRangeException
    {
        if((latitude < -180 || latitude > 180) || (longitude < -180 || longitude > 180))
        { throw new OutOfRangeException(); }
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
