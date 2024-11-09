package com.example.boutiquemicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BoutiqueMicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoutiqueMicroServiceApplication.class, args);
    }

}
