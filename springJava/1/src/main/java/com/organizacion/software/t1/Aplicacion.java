package com.organizacion.software.t1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class Aplicacion {

	public static void main(String[] args) {
		SpringApplication.run(Aplicacion.class, args);
	}
	
	@Bean
	public CommandLineRunner example(RepositorioCliente repository) {
		return (args) -> {
			// save a few customers
			repository.save(new Customer("Pablo", "Mesa"));
			repository.save(new Customer("Andres", "Mejia"));
			repository.save(new Customer("Carolina", "Zapata"));
			repository.save(new Customer("Valeria", "Jaramillo"));
			repository.save(new Customer("Pedro", "Sanchez"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Customer customer = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Mesa'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Mesa").forEach(mesa -> {
				log.info(mesa.toString());
			});
			log.info("");
		};
	}

}
