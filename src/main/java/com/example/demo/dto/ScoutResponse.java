package com.example.demo.dto;

import java.util.List;

import com.example.demo.models.Joueur;

public class ScoutResponse {

	private String nom;
	private String prenom;
	private String email;
	private String password;
	private List<Joueur> JoueursRecommandé;
	
	
	public ScoutResponse(String nom, String prenom, String email, String password,
			List<Joueur> joueursRecommandé) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		JoueursRecommandé = joueursRecommandé;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<Joueur> getJoueursRecommandé() {
		return JoueursRecommandé;
	}


	public void setJoueursRecommandé(List<Joueur> joueursRecommandé) {
		JoueursRecommandé = joueursRecommandé;
	}

	
	
}
