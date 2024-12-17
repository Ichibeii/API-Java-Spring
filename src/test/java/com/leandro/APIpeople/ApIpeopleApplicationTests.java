package com.leandro.APIpeople;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.leandro.APIpeople.entities.ManagementPeople;

@SpringBootTest (webEnvironment = WebEnvironment.RANDOM_PORT)
class ApIpeopleApplicationTests {
	
	@Autowired
	
	private WebTestClient webTestClient;

	@Test
	void textCreateManagementPeopleSucess() {
		
		var MP = new ManagementPeople(null, "Cristiane", 14586752874L, "cristiane123@gmail.com", "79994878524");
		webTestClient
		.post()
		.uri("/ManagementPeoples")
		.bodyValue(MP)
		.exchange()
		.expectStatus().isOk()
		.expectBody()
		.jsonPath("$").isArray()
		.jsonPath("$.lenght()").isEqualTo(1)
		.jsonPath("$[0].nome").isEqualTo(MP.getName())
		.jsonPath("$[0].cpf").isEqualTo(MP.getCpf())
		.jsonPath("$[0].email").isEqualTo(MP.getEmail())
		.jsonPath("$[0].numero").isEqualTo(MP.getNumero());
	}
	
	@Test
	void textCreateManagementPeopleFailure() {
		
		webTestClient
		.post()
		.uri("/ManagementPeoples")
		.bodyValue( new ManagementPeople(null, null, null, null, null))
		.exchange()
		.expectStatus().isBadRequest();
	}
	
	@Test
	void testListManagementPeopleSuccess() {
	    webTestClient
	        .get()
	        .uri("/ManagementPeoples")
	        .exchange()
	        .expectStatus().isOk()
	        .expectBody()
	        .jsonPath("$").isArray();
	}

	@Test
	void testUpdateManagementPeopleSuccess() {
	    var updated = new ManagementPeople(null, "Cristiane Atualizada", 14586752874L, "cristiane123@gmail.com", "79994878524");

	    webTestClient
	        .put()
	        .uri("/ManagementPeoples/atualizacao")
	        .bodyValue(updated)
	        .exchange()
	        .expectStatus().isOk()
	        .expectBody()
	        .jsonPath("$[0].name").isEqualTo("Cristiane Atualizada");
	}

	@Test
	void testDeleteManagementPeopleNotFound() {
	    webTestClient
	        .delete()
	        .uri("/ManagementPeoples/9999")
	        .exchange()
	        .expectStatus().isNotFound()
	        .expectBody()
	        .jsonPath("$.message").isEqualTo("Pessoa não encontrada com ID: 9999");
	}

	
	@Test
	void testGetManagementPeopleByNameSuccess() {
	    webTestClient
	        .get()
	        .uri("/ManagementPeoples/Cristiane")
	        .exchange()
	        .expectStatus().isOk()
	        .expectBody()
	        .jsonPath("$.name").isEqualTo("Cristiane");
	}

	@Test
	void testGetManagementPeopleByNameNotFound() {
	    webTestClient
	        .get()
	        .uri("/ManagementPeoples/NotExistente")
	        .exchange()
	        .expectStatus().is5xxServerError();
	}


}
