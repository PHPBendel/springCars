package com.phpb.cars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.phpb.cars.entity.Car;
import com.phpb.cars.service.CarsService;

import java.util.Collection;

@RestController
@RequestMapping("/cars")
public class CarController {
	
	@Autowired
	private CarsService carsService;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertCar(@RequestBody Car car) {
		carsService.insertCar(car);
	}

	@RequestMapping(method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteCar(@RequestBody Car car) {
		carsService.deleteCar(car);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Car> getAllCars() {
		return carsService.getAllCars();
	}
	
}