package com.paaste.coopy.backend.GoogleMaps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paaste.coopy.backend.Exceptions.OutOfRangeException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.DependsOn;

import java.io.IOException;

import static org.junit.Assert.*;

public class GoogleMapsClientTest
{
    GeoCoords origin, destination;
    DistanceMatrix distanceMatrix;
    GoogleMaps maps = new GoogleMapsClient();

    @Before
    public void setCoords()
    {
        try
        {
            origin = new GeoCoords(40.6655101, -73.89188969999998);
            destination = new GeoCoords(40.6905615,-73.9976592);
        }
        catch (OutOfRangeException e)
        {
            System.out.println(e.getMessage());
        }
    }

//    @Test
//    public void setDistanceMatrix()
//    {
//        distanceMatrix = maps.getDistanceMatrix(origin, destination);
//        Assert.assertNotEquals(null, distanceMatrix);
//    }

    @Test
    public void PrintRoute()
    {
        distanceMatrix = maps.getDistanceMatrix(origin, destination);
        System.out.println("From: " + distanceMatrix.origin_addresses.get(0));
        System.out.println("to: " + distanceMatrix.destination_addresses.get(0));
        System.out.println("Distance: " + distanceMatrix.rows.get(0).elements.get(0).distance
        .text);
        System.out.println("Estimated Time: " + distanceMatrix.rows.get(0).elements.get(0)
        .duration.text);
    }
}