package com.leandro.APIpeople.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.leandro.APIpeople.entities.ManagementPeople;
import com.leandro.APIpeople.repository.ManagementPeopleName;
import com.leandro.APIpeople.repository.ManagementPeopleRepository;

@Service
public class ManagementPeopleService {

	@Autowired
	private ManagementPeopleRepository managementPeopleRepository;
	
	@Autowired
	private ManagementPeopleName managementPeopleName;
	
	
	public List<ManagementPeople> createAll(List <ManagementPeople> managementPeople) {
		managementPeopleRepository.saveAll(managementPeople);
		return list();
	}

	public List<ManagementPeople> list() {
		
		//ordenação por nome
		
		Sort sort = Sort.by("name").ascending();
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
	
	public Optional<ManagementPeople> buscarPorNome (String name) {
		return managementPeopleName.findByName(name);
	}
}
