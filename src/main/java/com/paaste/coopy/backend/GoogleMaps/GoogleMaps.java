package com.paaste.coopy.backend.GoogleMaps;

import com.paaste.coopy.backend.domain.model.PickupPoint;

import java.util.List;

public interface GoogleMaps {
    DistanceMatrix getDistanceMatrix(GeoCoords origin, GeoCoords destination);
    List<PickupPoint> getTwoNearestPickupPoints(GeoCoords origin, List<PickupPoint> pickups);
}
