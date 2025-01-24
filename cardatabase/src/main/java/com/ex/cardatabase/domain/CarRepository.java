package com.ex.cardatabase.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
	// Filter cars by brand
	List<Car> findByBrand(String brand);
	
	// Fetch cars by color
	List<Car> findByColor(String color);
	
	// Fetch cars by model year
	List<Car> findByModelYear(int modelYear);
	
	// Fetch cars by brand and model
	List<Car> findByBrandAndModel(String brand, String model);
	
	// fetch cars by brand or color
	List<Car> findByBrandOrColor(String brand, String color);
	
	// Fetch cars by brand and sort by year
	List<Car> findByBrandOrderByModelYearAsc(String brand);

	// Fetch cars by brand using SQL
	// @Query("select c from Car c where c.brand like %?1")
	@Query("select c from Car c where c.brand = ?1")
	List<Car> findByBrandEndsWith(String brand);
}
