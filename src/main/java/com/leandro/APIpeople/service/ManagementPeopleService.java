package com.leandro.APIpeople.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.leandro.APIpeople.entities.ManagementPeople;
import com.leandro.APIpeople.repository.ManagementPeopleRepository;

@Service
public class ManagementPeopleService {

	
	private ManagementPeopleRepository managementPeopleRepository;
	
	@Autowired
	public ManagementPeopleService (ManagementPeopleRepository managementPeopleRepository) {
		this.managementPeopleRepository = managementPeopleRepository;
	}
	
	
	public List<ManagementPeople> create(ManagementPeople managementPeople) {
		managementPeopleRepository.save(managementPeople);
		return list();
	}

	public List<ManagementPeople> list() {
		
		//ordenação por nome
		
		Sort sort = Sort.by("Name").ascending();
		return managementPeopleRepository.findAll(sort);
	}

	public List<ManagementPeople> update(ManagementPeople managementPeople) {
		managementPeopleRepository.save(managementPeople);
		return list();
	}

	public List<ManagementPeople> delete(Long id) {
		managementPeopleRepository.deleteById(id);
		return list();
	}
}
