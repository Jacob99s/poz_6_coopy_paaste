package com.paaste.coopy.backend.Maps;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GoogleMapsClientTest
{
    GeoCoords origin, destination;
    DistanceMatrix distanceMatrix;
    Maps maps = new GoogleMapsClient();

    @Before
    public void setCoords()
    {
            origin = new GeoCoords(40.6655101, -73.89188969999998);
            destination = new GeoCoords(40.6905615,-73.9976592);
            distanceMatrix = maps.getDistanceMatrix(origin, destination);
    }

    @Test
    public void setDistanceMatrix()
    {
        distanceMatrix = null;
        distanceMatrix = maps.getDistanceMatrix(origin, destination);
        Assert.assertNotEquals(null, distanceMatrix);
    }

    @Test
    public void PrintRoute()
    {
        System.out.println("From: " + distanceMatrix.origin_addresses.get(0));
        System.out.println("to: " + distanceMatrix.destination_addresses.get(0));
        System.out.println("Distance: " + distanceMatrix.rows.get(0).elements.get(0).distance
        .text);
        System.out.println("Estimated Time: " + distanceMatrix.rows.get(0).elements.get(0)
        .duration.text);
    }
}
