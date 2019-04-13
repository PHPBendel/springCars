package com.phpb.cars.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.phpb.cars.entity.Car;

@Repository
public class CarsDao {

	EntityManagerFactory emf;

	@PersistenceContext
	EntityManager em;

	/**
	 * Since this service is a REST API, every function will create a new
	 * EntityManager and close it after we are done with the request
	 **/

	public CarsDao() {
		emf = Persistence.createEntityManagerFactory("carros");
	}

	public void insertCar(Car _car) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(_car);
		em.getTransaction().commit();
		em.close();
	}

	public void deleteCar(Car car) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		Car c = em.merge(car);
		em.remove(c);
		em.getTransaction().commit();
		em.close();
	}

	@SuppressWarnings("unchecked")
	public List<Car> getAllCars() {
		em = emf.createEntityManager();
		List<Car> result = em.createQuery("SELECT c FROM Car c").getResultList();
		em.close();
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Car> getCar(Car _car) {
		em = emf.createEntityManager();
		List<Car> result = em.createQuery("SELECT c FROM Car c WHERE id = ?1").setParameter(1, _car.getCarID())
				.getResultList();
		em.close();
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Car> getCarByVin(Car _car) {
		em = emf.createEntityManager();
		List<Car> result = em.createQuery("SELECT c FROM Car c WHERE carVin = ?1").setParameter(1, _car.getCarVin())
				.getResultList();
		em.close();
		return result;
	}
}