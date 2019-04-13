package com.paaste.coopy.backend.Pickups;

import com.paaste.coopy.backend.Exceptions.OutOfRangeException;
import com.paaste.coopy.backend.GoogleMaps.GeoCoords;
import com.paaste.coopy.backend.GoogleMaps.GoogleMaps;
import com.paaste.coopy.backend.GoogleMaps.GoogleMapsClient;
import com.paaste.coopy.backend.domain.PickupPointService;
import com.paaste.coopy.backend.domain.model.PickupPoint;
import com.paaste.coopy.backend.domain.model.PickupPoints;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PickupPlaces
{
    public  List<PickupPoint> getAllPickups(GeoCoords origin, int sellerID)
    {
        List<GeoCoords> coords = getMapCorners(origin);
        PickupPoints pointsForLocation =
                pickupPointService.findPointsForLocation(coords.get(0).getLatitude(),
                        coords.get(0).getLongitude(), coords.get(1).getLatitude(),
                        coords.get(1).getLongitude(), null, sellerID);
        return pointsForLocation.getPoints();
    }

    public List<PickupPoint> getBestPickups(GeoCoords origin, int sellerID)
    {
        List<GeoCoords> coords = getMapCorners(origin);
        PickupPoints pointsForLocation =
                pickupPointService.findPointsForLocation(coords.get(0).getLatitude(),
                        coords.get(0).getLongitude(), coords.get(1).getLatitude(),
                        coords.get(1).getLongitude(), null, sellerID);
        return maps.getTwoNearestPickupPoints(origin, pointsForLocation.getPoints());
    }

    public PickupPlaces(PickupPointService pickupPointService)
    {
        this.pickupPointService = pickupPointService;
    }

    private final PickupPointService pickupPointService;
    private GoogleMaps maps = new GoogleMapsClient();

    private List<GeoCoords> getMapCorners(GeoCoords origin)
    {
        double nwLat = origin.getLatitude() + toDegrees(3000.00);
        double nwLon = origin.getLongitude() - toDegrees(3000.00);
        double seLat = origin.getLatitude() - toDegrees(3000.00);
        double seLon = origin.getLongitude() + toDegrees(3000.00);
        List<GeoCoords> coords = new ArrayList<>();

        GeoCoords leftUpper, rightLower;
        leftUpper = new GeoCoords(nwLat, nwLon);
        rightLower = new GeoCoords(seLat, seLon);

        coords.add(leftUpper);
        coords.add(rightLower);
        return coords;
    }

    private double toDegrees(double meters)
    {
        double seconds = meters / 24.00;
        return (seconds / 3600);
    }
}
