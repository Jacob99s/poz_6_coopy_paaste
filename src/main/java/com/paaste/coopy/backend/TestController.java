package com.paaste.coopy.backend;

import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TestController {

    private final ApplicationContext context;

    public TestController(ApplicationContext context) {
        this.context = context;
    }


    @GetMapping("/beans")
    public ResponseEntity<List<String>> getAllBeans() {
        List<String> beans = Arrays.asList(context.getBeanDefinitionNames());
        return ResponseEntity.ok(beans);
    }
}
