package com.phpb.cars.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", updatable = false, nullable = false)
	private int carID;

	@Column
	private String carModel;
	@Column
	private String carYear;
	@Column
	private String carMaker;
	@Column
	private String carVin;
	@Column
	private int ownerId;

	public Car(String carModel, String carYear, String carMaker, String carVin, int ownerId) {
		super();
		this.carModel = carModel;
		this.carYear = carYear;
		this.carMaker = carMaker;
		this.carVin = carVin;
		this.ownerId = ownerId;
	}

	public Car() {
	}

	public int getCarID() {
		return carID;
	}

	public void setCarID(int carID) {
		this.carID = carID;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarYear() {
		return carYear;
	}

	public void setCarYear(String carYear) {
		this.carYear = carYear;
	}

	public String getCarMaker() {
		return carMaker;
	}

	public void setCarMaker(String carMaker) {
		this.carMaker = carMaker;
	}

	public String getCarVin() {
		return carVin;
	}

	public void setCarVin(String carVin) {
		this.carVin = carVin;
	}
	

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	@Override
	public String toString() {
		return "Car [carID=" + carID + ", carModel=" + carModel + ", carYear=" + carYear + ", carMaker=" + carMaker
				+ ", carVin=" + carVin + ", ownerId=" + ownerId + "]";
	}	
}
