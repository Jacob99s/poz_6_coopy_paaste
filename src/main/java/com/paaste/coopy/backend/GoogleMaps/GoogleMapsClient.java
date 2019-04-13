package com.paaste.coopy.backend.GoogleMaps;

import org.springframework.web.client.RestTemplate;

public class GoogleMapsClient implements GoogleMaps {

    @Override
    public DistanceMatrix getDistanceMatrix(GeoCoords origin, GeoCoords destination)
    {
        String uri =
                "https://maps.googleapis.com/maps/api/distancematrix/json?&origins=" + origin.getLatitude() +
                "," + origin.getLongitude() + "&destinations=" + destination.getLatitude() + "," + destination.getLongitude() + "&key=AIzaSyCJkiekbMK0DsVdFsrSEts_WlgvxCfPThA";
        DistanceMatrix distanceMatrix = restTemplate.getForObject(uri, DistanceMatrix.class);
        return distanceMatrix;
    }

    private RestTemplate restTemplate = new RestTemplate();

}
