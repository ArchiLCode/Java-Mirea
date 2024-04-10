package com.example.practice11;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestHello {

    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name", defaultValue = "world") String name) {
        return String.format("Hello, %s!", name);
    }
}
