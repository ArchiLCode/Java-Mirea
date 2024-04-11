package com.example.practice12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Practice12Application {
    public static void main(String... args) {
        ApplicationContext context = SpringApplication.run(Practice12Application.class, args);
        new ComponentClass();
        SpringApplication.exit(context);
    }
}