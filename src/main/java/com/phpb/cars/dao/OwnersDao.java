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

	/**
	 * Since this service is a REST API, every function will create a new EntityManager
	 * and close it after we are done with the request
	 **/

	public OwnersDao() {
		emf = Persistence.createEntityManagerFactory("carros");
	}

	public void insertOwner(Owner _owner) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(_owner);
		em.getTransaction().commit();
		em.close();
	}

	public void deleteOwner(Owner _owner) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		Owner o = em.merge(_owner);
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}

	@SuppressWarnings("unchecked")
	public List<Owner> getAllOwners() {
		em = emf.createEntityManager();
		List<Owner> result = em.createQuery("SELECT c FROM Owner c").getResultList();
		em.close();	
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Owner> getOwnerById(Owner _owner) {
		em = emf.createEntityManager();
		List<Owner> result = em.createQuery("SELECT c FROM Owner c WHERE id = ?1").setParameter(1, _owner.getOwnerId())
				.getResultList();
		em.close();
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Owner> getOwnerByEmail(Owner _owner) {
		em = emf.createEntityManager();
		List<Owner> result = em.createQuery("SELECT c FROM Owner c WHERE ownerEMail = ?1")
				.setParameter(1, _owner.getOwnerEMail()).getResultList();
		em.close();
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Car> getOwnerCars(Owner _owner) {
		em = emf.createEntityManager();
		List<Car> result = em.createQuery("SELECT c FROM Car c WHERE ownerId = ?1").setParameter(1, _owner.getOwnerId())
				.getResultList();
		em.close();
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