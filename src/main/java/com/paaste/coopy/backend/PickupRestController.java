package com.paaste.coopy.backend;

import com.paaste.coopy.backend.Maps.GeoCoords;
import com.paaste.coopy.backend.Pickups.PickupPlaces;
import com.paaste.coopy.backend.Pickups.PickupPoint;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pickups")
public class PickupRestController {

    private final PickupPlaces pickupPlaces;

    public PickupRestController(PickupPlaces pickupPlaces) {
        this.pickupPlaces = pickupPlaces;
    }

    @GetMapping("/suggested")
    public ResponseEntity<List<PickupPoint>> suggestedPickupPointsForLocation(@RequestParam double origLat,
                                                                     @RequestParam double origLon
            ,@RequestParam int sellerID) {
        return ResponseEntity.ok(pickupPlaces.getBestPickups(new GeoCoords(origLat, origLon),
                sellerID));
    }

    @GetMapping
    public ResponseEntity<List<PickupPoint>> allPickupPointsForLocation(@RequestParam double origLat, @RequestParam double origLon, @RequestParam int sellerID)
    {
        return ResponseEntity.ok(pickupPlaces.getAllPickups(new GeoCoords(origLat, origLon),
                sellerID));
    }
}
