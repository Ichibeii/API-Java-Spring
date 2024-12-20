package com.leandro.APIpeople.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.DocumentException;
import com.leandro.APIpeople.entities.ManagementPeople;
import com.leandro.APIpeople.service.ManagementPeopleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/ManagementPeoples")
public class ManagemenPeoplecontroler {
	
	@Autowired
	
	private ManagementPeopleService managementPeopleService;

	@PostMapping
	List<ManagementPeople> create(@RequestBody @Valid List<ManagementPeople> managementPeople) {

		return managementPeopleService.createAll(managementPeople);
	}

	@GetMapping
	List<ManagementPeople> list() {
		return managementPeopleService.list();
	}

	@PutMapping ("/atualizacao")
	List<ManagementPeople> update(@RequestBody ManagementPeople managementPeople) {
		return managementPeopleService.update(managementPeople);
	}

	@DeleteMapping ("{id}")
	List<ManagementPeople> delete(@PathVariable ("id") Long id) {

		return managementPeopleService.delete(id);
	}
	
	@GetMapping("{name}")
    public ManagementPeople buscarPorNome(@PathVariable ("name") String name) {
        Optional<ManagementPeople> pessoa = managementPeopleService.buscarPorNome(name);
        if (pessoa.isPresent()) {
            return pessoa.get();
        } else {
            throw new RuntimeException("Pessoa não encontrada com nome: " + name);
        }
    }
	
	@GetMapping("/gerar-pdf")
	public ResponseEntity<byte[]> gerarRelatorio() throws DocumentException, IOException {
        List<ManagementPeople> people = managementPeopleService.list();
        byte[] pdf = managementPeopleService.gerarRelatorio(people);
        
     // Retornando o PDF como um arquivo para download
        
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=relatorio.pdf")
                .header(HttpHeaders.CONTENT_TYPE, "application/pdf")
                .body(pdf);
}
}
