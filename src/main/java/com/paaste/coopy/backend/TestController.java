package com.paaste.coopy.backend;

import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class TestController {

    private final ApplicationContext context;
    private String headers;
    Points points = new Points();
    public UserData userData = new UserData();

    public TestController(ApplicationContext context) {
        this.context = context;
    }


    @GetMapping("/api/{id}")
    public List<PickupPoint> getUserData(@PathVariable(name = "id") int id) {
        List<PickupPoint> tmp = new ArrayList<>();
        tmp = points.GetSuggestedPoint(userData.recently_pickup, id);
        return tmp;
    }

}
