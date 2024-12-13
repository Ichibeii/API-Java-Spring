package com.leandro.APIpeople.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leandro.APIpeople.entities.ManagementPeople;

public interface ManagementPeopleRepository extends JpaRepository<ManagementPeople, Long> {

}
