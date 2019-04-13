package com.phpb.cars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phpb.cars.dao.OwnersDao;
import com.phpb.cars.entity.Car;
import com.phpb.cars.entity.Owner;

@Service
public class OwnerService {
	
	@Autowired
	private OwnersDao ownersDao = new OwnersDao();

	public void insertOwner(Owner _owner) {
		try {

			if (!ownersDao.getOwnerByEmail(_owner).isEmpty()) {
				throw new Exception("User already registered...");
			}
			ownersDao.insertOwner(_owner);

		} catch (Exception e) {

			System.out.println(e);
		}
	}

	public void deleteOwner(Owner _owner) {
		try {

			if (ownersDao.getOwnerByEmail(_owner).isEmpty()) {
				throw new Exception("No user found!");
			}
			
			ownersDao.deleteAllCarsFromOwner(_owner);
			ownersDao.deleteOwner(_owner);

		} catch (Exception e) {

			System.out.println(e);
		}
	}

	public List<Car> getCarsByOwner(Owner _owner) {
		List<Car> ownerCars = null;
		try {

			if (ownersDao.getOwnerByEmail(_owner).isEmpty()) {
				throw new Exception("No user found!");
			}

			ownerCars = ownersDao.getOwnerCars(_owner);

		} catch (Exception e) {
			System.out.println(e);
		}
		return ownerCars;
	}
}