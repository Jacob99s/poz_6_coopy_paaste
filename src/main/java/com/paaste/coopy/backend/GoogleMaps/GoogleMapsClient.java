package com.paaste.coopy.backend.GoogleMaps;

import com.paaste.coopy.backend.domain.model.PickupPoint;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GoogleMapsClient implements GoogleMaps
{

    @Override
    public DistanceMatrix getDistanceMatrix(GeoCoords origin, GeoCoords destination)
    {
        String uri =
                "https://maps.googleapis.com/maps/api/distancematrix/json?&origins=" + origin.getLatitude() +
                        "," + origin.getLongitude() + "&destinations=" + destination.getLatitude() + "," + destination.getLongitude() + "&key=AIzaSyCJkiekbMK0DsVdFsrSEts_WlgvxCfPThA";
        DistanceMatrix distanceMatrix = restTemplate.getForObject(uri, DistanceMatrix.class);
        return distanceMatrix;
    }

    @Override
    public List<PickupPoint> getTwoNearestPickupPoints(GeoCoords origin, List<PickupPoint> pickups)
    {
        List<PickupPoint> result = pickups.stream()
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
        return result;
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
