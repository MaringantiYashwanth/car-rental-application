package com.ex.cardatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.ex.cardatabase.domain.Car;
import com.ex.cardatabase.domain.CarRepository;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {
	private final CarRepository repository;

	public CardatabaseApplication(CarRepository repository) {
		this.repository = repository;
	}

	private static final Logger log = LoggerFactory.getLogger(CardatabaseApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
		log.info("Application Started");
	}

	@Override
	public void run(String... args) throws Exception {
		repository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2023, 59000));
		repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2020, 29000));
		repository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2022, 39000));
		
		// Fetch all cars and log to console
		for (Car car: repository.findAll()) {
			log.info("brand: {}, model: {}", car.getBrand(), car.getModel());
		}
	}

}

/*
 * Chapter 2: Basics of ORM, JPA, and Hibernate Create the entity classes Create
 * the CRUD repositories Adding relationships between tables Setting up the
 * MariaDB database ORM, JPA widely used for handling relational dbs
 */
