package com.paaste.coopy.backend.Pickups;

import com.paaste.coopy.backend.Maps.GeoCoords;
import com.paaste.coopy.backend.Maps.GoogleMapsClient;
import com.paaste.coopy.backend.Maps.Maps;
import com.paaste.coopy.backend.infrastructure.UserRepository;
import com.paaste.coopy.backend.user.Location;
import com.paaste.coopy.backend.user.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PickupPlaces {

    private final PickupPointService pickupPointService;

    private Maps maps = new GoogleMapsClient();

    @Qualifier("MockUserRepository")
    private final UserRepository userRepository;

    public PickupPlaces(PickupPointService pickupPointService, UserRepository userRepository) {
        this.pickupPointService = pickupPointService;
        this.userRepository = userRepository;
    }

    public List<PickupPoint> getAllPickups(int userId, int sellerID) {
        User user = userRepository.find(userId);
        Location preferredPickupPlaceLocation = user.getPreferredPickupPlace().getPickupPlace().getAddress().getLocation();

        PickupPoints pickupPoints = findPickupPoints(new GeoCoords(preferredPickupPlaceLocation.latitude(),
                preferredPickupPlaceLocation.longitude()), sellerID);
        return pickupPoints.getPoints();
    }

    public List<PickupPoint> getBestPickups(int userId, int sellerID) {
        User user = userRepository.find(userId);

        Location preferredPickupPlaceLocation = user.getPreferredPickupPlace().getPickupPlace().getAddress().getLocation();
        GeoCoords geoCoords = new GeoCoords(preferredPickupPlaceLocation.latitude(), preferredPickupPlaceLocation.longitude());
        PickupPoints pickupPointsNearestUserPreferredPickupPoint = findPickupPoints(geoCoords, sellerID);

        List<PickupPoint> nearestPoints = maps.getTwoNearestPickupPoints(geoCoords, pickupPointsNearestUserPreferredPickupPoint.getPoints());

        Location location = user.getHomeAddress().getAddress().getLocation();
        geoCoords = new GeoCoords(location.latitude(), location.longitude());
        PickupPoints pickupPointsNearestCustomer = findPickupPoints(geoCoords, sellerID);
        List<PickupPoint> preferredPickupPointsNearestCustomer = maps.getTwoNearestPickupPoints(geoCoords,
                pickupPointsNearestCustomer.getPoints());

        nearestPoints.addAll(preferredPickupPointsNearestCustomer);
        return nearestPoints;
    }

    private PickupPoints findPickupPoints(GeoCoords origin, int sellerID) {
        List<GeoCoords> coords = getMapCorners(origin);
        return pickupPointService.findPointsForLocation(coords.get(0).getLatitude(),
                coords.get(0).getLongitude(), coords.get(1).getLatitude(),
                coords.get(1).getLongitude(), null, sellerID);
    }

    private List<GeoCoords> getMapCorners(GeoCoords origin) {
        double nwLat = origin.getLatitude() + toDegrees(3000.00);
        double nwLon = origin.getLongitude() - toDegrees(3000.00);
        double seLat = origin.getLatitude() - toDegrees(3000.00);
        double seLon = origin.getLongitude() + toDegrees(3000.00);
        List<GeoCoords> coords = new ArrayList<>();

        coords.add(new GeoCoords(nwLat, nwLon));
        coords.add(new GeoCoords(seLat, seLon));
        return coords;
    }

    private double toDegrees(double meters) {
        double seconds = meters / 24.00;
        return (seconds / 3600);
    }

    public List<PickupPoint> getPlacesInArea(double latitude, double longitude, int sellerID) {
        return findPickupPoints(new GeoCoords(latitude, longitude), sellerID).getPoints();
    }
}
