package com.paaste.coopy.backend.Pickups;

import com.paaste.coopy.backend.Maps.GeoCoords;
import com.paaste.coopy.backend.Maps.Maps;
import com.paaste.coopy.backend.Maps.GoogleMapsClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PickupPlaces
{
    public  List<PickupPoint> getAllPickups(GeoCoords origin, int sellerID)
    {
        List<GeoCoords> coords = getMapCorners(origin);
        PickupPoints pointsForLocation = pickupPointService
                .findPointsForLocation(
                        coords.get(0).getLatitude(),
                        coords.get(0).getLongitude(),
                        coords.get(1).getLatitude(),
                        coords.get(1).getLongitude(),
                        null, sellerID);
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
    private Maps maps = new GoogleMapsClient();

    private List<GeoCoords> getMapCorners(GeoCoords origin)
    {
        double nwLat = origin.getLatitude() + toDegrees(3000.00);
        double nwLon = origin.getLongitude() - toDegrees(3000.00);
        double seLat = origin.getLatitude() - toDegrees(3000.00);
        double seLon = origin.getLongitude() + toDegrees(3000.00);
        List<GeoCoords> coords = new ArrayList<>();

        coords.add(new GeoCoords(nwLat, nwLon));
        coords.add(new GeoCoords(seLat, seLon));
        return coords;
    }

    private double toDegrees(double meters)
    {
        double seconds = meters / 24.00;
        return (seconds / 3600);
    }
}
