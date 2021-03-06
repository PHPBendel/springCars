package com.phpb.cars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phpb.cars.dao.CarsDao;
import com.phpb.cars.dao.OwnersDao;
import com.phpb.cars.entity.Car;

@Service
public class CarsService {

	@Autowired
	private CarsDao carsDao = new CarsDao();
	
	@Autowired
	private OwnersDao ownersDao = new OwnersDao();

	public void insertCar(Car _car) {
		try {
			if (!carsDao.getCarByVin(_car).isEmpty()) {
				throw new Exception("VIN already registered...");
			}
			
			if (ownersDao.getOwnerById(_car.getOwnerId()).isEmpty()) {
				throw new Exception("User not found!");
			}

			carsDao.insertCar(_car);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void deleteCar(Car _car) {
		try {
			if (carsDao.getCar(_car).isEmpty()) {
				throw new Exception("Car not found!");
			}

			carsDao.deleteCar(_car);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public List<Car> getAllCars() {
		List<Car> allCars = null;
		try {

			allCars = carsDao.getAllCars();

		} catch (Exception e) {

			System.out.println(e);
		}

		return allCars;
	}
}