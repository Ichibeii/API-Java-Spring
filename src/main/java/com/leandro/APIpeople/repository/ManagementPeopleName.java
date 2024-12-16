package com.leandro.APIpeople.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import com.leandro.APIpeople.entities.ManagementPeople;

public interface ManagementPeopleName extends JpaRepository<ManagementPeople, Long> {
    // Método para buscar por nome
    Optional<ManagementPeople> findByName(String name);
}
