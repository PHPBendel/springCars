package com.phpb.cars.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.phpb.cars.entity.Car;
import com.phpb.cars.entity.Owner;
import com.phpb.cars.service.OwnerService;

@RestController
@RequestMapping("/owners")
public class OwnerController {

	@Autowired
	private OwnerService ownerService;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertOwner(@RequestBody Owner owner) {
		ownerService.insertOwner(owner);
	}

	@RequestMapping(method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteOwner(@RequestBody Owner owner) {
		ownerService.deleteOwner(owner);
	}

	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Collection<Car> getCarsByOwner(@RequestBody Owner owner) {
		return ownerService.getCarsByOwner(owner);
	}
}