package com.esprit.prodouih;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class ProdouiHApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProdouiHApplication.class, args);
	}

	@Autowired
	private ProduitRepository repository;

	@Bean
	ApplicationRunner init() {
		return (args) -> {
			// Save some initial products
			repository.save(new Produit("Mariem", 12, 66));
			repository.save(new Produit("Hadir", 15, 120));

			// Fetch and print all products
			repository.findAll().forEach(System.out::println);
		};
	}
}
