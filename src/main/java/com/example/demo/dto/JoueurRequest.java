package com.example.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoueurRequest {
	
	//@NotBlank(message = "Name must be not Empty")
	//@Size(max = 50, min = 3)
	//@Pattern(regexp = "[a-zA-Z ]+", message = "Name must contain only characters")
	private String nom;
	//@NotBlank(message = "Prenom must be not Empty")
	private String prenom;
	private String adresse;
	private String password;
	//@Pattern(regexp = "[a-zA-Z ]+", message = "nationalite must contain only characters")
	private String nationalite;
	private boolean disponibilite;
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public String getPassword() {
		return password;
	}
	public String getNationalite() {
		return nationalite;
	}
	public boolean isDisponibilite() {
		return disponibilite;
	}
	
	

}
