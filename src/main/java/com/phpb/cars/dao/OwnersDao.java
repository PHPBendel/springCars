package com.phpb.cars.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import com.phpb.cars.entity.Owner;
import com.phpb.cars.entity.Car;

import com.phpb.cars.dao.CarsDao;

public class OwnersDao {

	EntityManagerFactory emf;
	@PersistenceContext
	EntityManager em;

	public OwnersDao() {
		emf = Persistence.createEntityManagerFactory("carros");
		em = emf.createEntityManager();
	}

	public void insertOwner(Owner _owner) {
		em.getTransaction().begin();
		em.merge(_owner);
		em.getTransaction().commit();
	}

	public void deleteOwner(Owner _owner) {
		this.deleteAllCarsFromOwner(_owner);
		em.getTransaction().begin();
		Owner o = em.merge(_owner);
		em.remove(o);
		em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<Owner> getAllOwners() {
		List<Owner> result = em.createQuery("SELECT c FROM Owner c").getResultList();
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Owner> getOwner(int id) {
		List<Owner> result = em.createQuery("SELECT c FROM Owner c WHERE id = ?1").setParameter(1, id).getResultList();
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Car> getOwnerCars(Owner _owner) {
		List<Car> result = em.createQuery("SELECT c FROM Car c WHERE ownerId = ?1").setParameter(1, _owner.getOwnerId())
				.getResultList();
		return result;
	}

	public void deleteAllCarsFromOwner(Owner _owner) {
		List<Car> ownerCars = getOwnerCars(_owner);
		CarsDao carsDao = new CarsDao();

		for (Car car : ownerCars) {
			carsDao.deleteCar(car);
		}
	}
}