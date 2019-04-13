package com.paaste.coopy.backend.Maps;

import com.paaste.coopy.backend.Pickups.PickupPoint;

import java.util.List;

public interface Maps {
    DistanceMatrix getDistanceMatrix(GeoCoords origin, GeoCoords destination);
    List<PickupPoint> getTwoNearestPickupPoints(GeoCoords origin, List<PickupPoint> pickups);
}
