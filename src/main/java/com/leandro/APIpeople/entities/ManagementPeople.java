package com.leandro.APIpeople.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table (name = "Peoples")
public class ManagementPeople {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long Id;
	@NotBlank
	private String Name;
	@NotBlank
	private String Cpf;
	@NotBlank
	private String Email;
	@NotBlank
	private String Numero;
	
	public ManagementPeople () {
		
	}
	
	public ManagementPeople (Long Id, String Name, String Cpf, String Email, String Numero) {
		this.Id = Id;
		this.Name = Name;
		this.Cpf = Cpf;
		this.Email = Email;
		this.Numero = Numero;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCpf() {
		return Cpf;
	}

	public void setCpf(String cpf) {
		Cpf = cpf;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getNumero() {
		return Numero;
	}

	public void setNumero(String numero) {
		Numero = numero;
	}
	
}
