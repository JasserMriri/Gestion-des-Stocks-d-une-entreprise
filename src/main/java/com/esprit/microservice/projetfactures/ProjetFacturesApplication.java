package com.esprit.microservice.projetfactures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
@EnableDiscoveryClient
@SpringBootApplication
public class ProjetFacturesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetFacturesApplication.class, args);
    }
    @Autowired
    private FactureRepository repository;

    @Bean
    ApplicationRunner init() {
        return (args) -> {
            // save
            repository.save(new Facture("242FFFff","Mariem", "Ch", "ma@esprit.tn","hdh@hhdhd",223332,27277 ));
           // repository.save(new Facture( "242FFF","Mariem", "Ch", "ma@esprit.tn","hdh@hhdhd",222,27277  ));

            // fetch
            repository.findAll().forEach(System.out::println);

        };
    }

}
