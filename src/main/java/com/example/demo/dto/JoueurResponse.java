package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
public class JoueurResponse {

	
	private String nom;
	private String prenom;
	private String adresse;
	private String password;
	private String nationalite;
	private boolean disponibilite;
	
	
	public JoueurResponse() {
		super();
	}



	public JoueurResponse(String nom, String prenom, String adresse,  String nationalite,
			boolean disponibilite) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	
		this.nationalite = nationalite;
		this.disponibilite = disponibilite;
	}



	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getNationalite() {
		return nationalite;
	}
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	public boolean isDisponibilite() {
		return disponibilite;
	}
	public void setDisponibilite(boolean disponibilite) {
		this.disponibilite = disponibilite;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
