package com.paaste.coopy.backend;

import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@RestController
public class TestController {

    private final ApplicationContext context;
    private String headers;

    public TestController(ApplicationContext context) {
        this.context = context;
    }


    @GetMapping("/beans")
    public ResponseEntity<List<String>> getAllBeans() {
        List<String> beans = Arrays.asList(context.getBeanDefinitionNames());
        return ResponseEntity.ok(beans);
    }

    @GetMapping("/pointsSet/{id}")
    public String getPoints(@PathVariable(name = "id") int id) {
//        pickupPoint pickupOb = new pickupPoint(1, "shop", 57.200, 16.17);
        setPoint points = new setPoint();
        return points.getPoint(id).toJSON();
    }
}
