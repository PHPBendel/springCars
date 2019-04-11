package com.phpb.cars.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import com.phpb.cars.entity.Car;

public class CarsDao {

	EntityManagerFactory emf;

	@PersistenceContext
	EntityManager em;

	public CarsDao() {
		emf = Persistence.createEntityManagerFactory("carros");
		em = emf.createEntityManager();
	}

	public void insertCar(Car _car) {
		em.getTransaction().begin();
		em.merge(_car);
		em.getTransaction().commit();
	}

	public void deleteCar(Car car) {
		em.getTransaction().begin();
		Car c = em.merge(car);
		em.remove(c);
		em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<Car> getAllCars() {
		List<Car> result = em.createQuery("SELECT c FROM Car c").getResultList();
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Car> getCar(int id) {
		List<Car> result = em.createQuery("SELECT c FROM Car c WHERE id = ?1").setParameter(1, id).getResultList();
		return result;
	}
}