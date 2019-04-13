package com.paaste.coopy.backend.domain;

import com.paaste.coopy.backend.domain.model.PickupPoints;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PickupPointService {

    private final RestTemplate restTemplate;

    public PickupPointService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public PickupPoints findPointsForLocation(double nwLat, double nwLon, double seLat, double seLon, String deliveryMethods, int sellerId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/vnd.allegro.public.v3+json");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        String url = "/general-deliveries?clusterThreshold=1000000" +
                "&nwLat=" + nwLat + "&nwLon=" + nwLon + "&seLat=" + seLat + "&seLon=" + seLon
                + "&sellerId=" + sellerId;
        System.out.println(url);
        ResponseEntity<PickupPoints> pickupPoints = restTemplate.exchange(url, HttpMethod.GET, entity , PickupPoints.class);
        return pickupPoints.getBody();
    }

}
