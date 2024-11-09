package tn.esprit.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EntityScan(basePackages = {"tn.esprit.spring.entitities"})
@EnableDiscoveryClient
@SpringBootApplication
public class BoutiqueMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoutiqueMicroserviceApplication.class, args);
    }

}
