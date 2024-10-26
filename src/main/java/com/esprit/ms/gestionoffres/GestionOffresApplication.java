package com.esprit.ms.gestionoffres;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@EnableDiscoveryClient
@SpringBootApplication
public class GestionOffresApplication {

	@Autowired
	private OffreRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(GestionOffresApplication.class, args);
	}

	@Bean
	ApplicationRunner init() {
		return args -> {
			repository.save(new Offre("Offre 1", "Description 1", 100.0, new Date(), new Date()));
			repository.save(new Offre("Offre 2", "Description 2", 150.0, new Date(), new Date()));
			repository.save(new Offre("Offre 3", "Description 3", 200.0, new Date(), new Date()));
			repository.save(new Offre("Offre 4", "Description 4", 250.0, new Date(), new Date()));

			// Fetch and print all offers
			repository.findAll().forEach(offre -> System.out.println(offre.getTitre()));
		};
	}
}
