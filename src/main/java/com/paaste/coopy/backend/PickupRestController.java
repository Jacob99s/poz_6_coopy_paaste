package com.paaste.coopy.backend;

import com.paaste.coopy.backend.domain.PickupPointService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pickups")
public class PickupRestController {

    private final PickupPointService pickupPointService;

    public PickupRestController(PickupPointService pickupPointService) {
        this.pickupPointService = pickupPointService;
    }

    @GetMapping
    public ResponseEntity<Void> pickupPointsForLocation() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
