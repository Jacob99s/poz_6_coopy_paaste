package com.paaste.coopy.backend;

import com.paaste.coopy.backend.GoogleMaps.GeoCoords;
import com.paaste.coopy.backend.Pickups.PickupPlaces;
import com.paaste.coopy.backend.domain.model.PickupPoint;
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
}
