package com.paaste.coopy.backend;

import com.paaste.coopy.backend.Pickups.PickupPlaces;
import com.paaste.coopy.backend.Pickups.PickupPoint;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pickups")
public class PickupRestController {

    private final PickupPlaces pickupPlaces;

    public PickupRestController(PickupPlaces pickupPlaces) {
        this.pickupPlaces = pickupPlaces;
    }

    @GetMapping("/suggested/{id}")
    public ResponseEntity<List<PickupPoint>> suggestedPickupPointsForLocation(@PathVariable(name = "id") int userId,
                                                                              @RequestParam int sellerID) {
        return ResponseEntity.ok(pickupPlaces.getBestPickups(userId, sellerID));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<PickupPoint>> allPickupPointsForLocation(@PathVariable(name = "id") int userId,
                                                                        @RequestParam int sellerID) {
        return ResponseEntity.ok(pickupPlaces.getAllPickups(userId, sellerID));
    }

    @GetMapping("/area")
    public ResponseEntity<List<PickupPoint>> getPickupsInArea(@RequestParam(name = "lat") double latitude,
                                                              @RequestParam(name = "lon") double longitude,
                                                              @RequestParam(name = "sellerID") int sellerID) {
        return ResponseEntity.ok(pickupPlaces.getPlacesInArea(latitude,longitude, sellerID));
    }
}
