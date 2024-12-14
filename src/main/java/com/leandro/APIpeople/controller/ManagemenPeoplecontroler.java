package com.leandro.APIpeople.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leandro.APIpeople.entities.ManagementPeople;
import com.leandro.APIpeople.service.ManagementPeopleService;

@RestController
@RequestMapping("/ManagementPeoples")
public class ManagemenPeoplecontroler {
	
	@Autowired
	
	private ManagementPeopleService managementPeopleService;

	@PostMapping
	List<ManagementPeople> create(@RequestBody ManagementPeople managementPeople) {

		return managementPeopleService.create(managementPeople);
	}

	@GetMapping
	List<ManagementPeople> list() {
		return managementPeopleService.list();
	}

	@PutMapping
	List<ManagementPeople> update(@RequestBody ManagementPeople managementPeople) {
		return managementPeopleService.update(managementPeople);
	}

	@DeleteMapping ("{id}")
	List<ManagementPeople> delete(@PathVariable ("id") Long id) {

		return managementPeopleService.delete(id);
	}

}
