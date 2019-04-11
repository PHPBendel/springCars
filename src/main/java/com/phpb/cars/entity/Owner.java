package com.phpb.cars.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", updatable = false, nullable = false)
	private int ownerId;

	@Column
	private String ownerFirstName;
	@Column
	private String ownerLastName;
	@Column
	private String ownerEMail;

	public Owner(String ownerFirstName, String ownerLastName, String ownerEMail) {
		super();
		this.ownerFirstName = ownerFirstName;
		this.ownerLastName = ownerLastName;
		this.ownerEMail = ownerEMail;
	}

	public Owner() {
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerFirstName() {
		return ownerFirstName;
	}

	public void setOwnerFirstName(String ownerFirstName) {
		this.ownerFirstName = ownerFirstName;
	}

	public String getOwnerLastName() {
		return ownerLastName;
	}

	public void setOwnerLastName(String ownerLastName) {
		this.ownerLastName = ownerLastName;
	}

	public String getOwnerEMail() {
		return ownerEMail;
	}

	public void setOwnerEMail(String ownerEMail) {
		this.ownerEMail = ownerEMail;
	}
	
	@Override
	public String toString() {
		return "Owner [ownerId=" + ownerId + ", ownerFirstName=" + ownerFirstName + ", ownerLastName=" + ownerLastName
				+ ", ownerEMail=" + ownerEMail + "]";
	}
}