package com.example.gsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class GspApplication {
    public static void main(String[] args) {
        SpringApplication.run(GspApplication.class, args);
    }
}