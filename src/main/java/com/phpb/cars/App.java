package com.phpb.cars;

import java.util.Arrays;
import java.util.List;

import com.phpb.cars.dao.CarsDao;
import com.phpb.cars.dao.OwnersDao;

import com.phpb.cars.entity.Car;
import com.phpb.cars.entity.Owner;

public class App {
	public static void main(String[] args) {
		CarsDao carros = new CarsDao();

		try {
			Owner umDono = new Owner("Pedro", "Bendel", "pedro.bendel@gmail.com");
			OwnersDao ownersDao = new OwnersDao();

			ownersDao.insertOwner(umDono);
			System.out.println(umDono.getOwnerId());
			
			List<Owner> ownersList = ownersDao.getAllOwners();
			for (Owner owner : ownersList) {
				System.out.println(owner.toString());
			}
			
//			List<Owner> listaDeDonos = ownersDao.getAllOwners();
//			for (Owner owner : listaDeDonos) {
//				
//			}

//			List<Car> carsList = carros.getAllCars();
//			for (Car car : carsList) {
//				System.out.println(car.toString());
//			}

//			carsList = carros.getCar(6);
//			for (Car car : carsList) {
//				System.out.println(car.toString());
//			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
