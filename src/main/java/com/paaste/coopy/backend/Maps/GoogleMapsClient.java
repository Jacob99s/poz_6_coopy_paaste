package com.paaste.coopy.backend.Maps;

import com.paaste.coopy.backend.Pickups.Coordinate;
import com.paaste.coopy.backend.Pickups.PickupPoint;
import org.springframework.web.client.RestTemplate;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GoogleMapsClient implements Maps
{

    @Override
    public DistanceMatrix getDistanceMatrix(GeoCoords origin, GeoCoords destination)
    {
        String uri = "https://maps.googleapis.com/maps/api/distancematrix/json?&origins=" + origin.getLatitude() +
                "," + origin.getLongitude() + "&destinations=" + destination.getLatitude() +
                "," + destination.getLongitude() + "&key=AIzaSyCJkiekbMK0DsVdFsrSEts_WlgvxCfPThA";

        return restTemplate.getForObject(uri, DistanceMatrix.class);
    }

    @Override
    public List<PickupPoint> getTwoNearestPickupPoints(GeoCoords origin, List<PickupPoint> pickups)
    {
        Coordinate coordinate = new Coordinate();
        coordinate.latitude = origin.getLatitude();
        coordinate.longitude = origin.getLongitude();

        return pickups.stream()
                .filter(pickupPoint -> !pickupPoint.coordinates.equals(coordinate))
                .map(pickupPoint -> {
                    PickupData pickupData = new PickupData();
                    pickupData.distance = getDistance(getDistanceMatrix(origin, new GeoCoords(pickupPoint.coordinates)));
                    pickupData.origin = origin;
                    pickupData.pickupPoint = pickupPoint;
                    return pickupData;
                })
                .filter(pickupPoint -> pickupPoint.distance < 3000)
                .sorted(Comparator.comparingInt(o -> o.distance))
                .map(pickupData -> pickupData.pickupPoint)
                .limit(2)
                .collect(Collectors.toList());
    }

    private int getDistance(DistanceMatrix distanceMatrix)
    {
        if (distanceMatrix.rows.get(0) != null)
        {
            return distanceMatrix.rows.get(0).elements.get(0).distance.value;
        }
        return 100000;
    }

    private RestTemplate restTemplate = new RestTemplate();

    private class PickupData {
        public GeoCoords origin;
        public PickupPoint pickupPoint;
        int distance;
    }
}
