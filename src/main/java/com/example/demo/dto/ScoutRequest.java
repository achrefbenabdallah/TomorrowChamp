package com.example.demo.dto;

import java.util.List;

import com.example.demo.models.Joueur;

public class ScoutRequest {

		//@NotBlank(message = "Name must be not Empty")
		//@Size(max = 50, min = 3)
		//@Pattern(regexp = "[a-zA-Z ]+", message = "Name must contain only characters")
		private String nom;
		//@NotBlank(message = "Prenom must be not Empty")
		private String prenom;
		private String email;
		private String password;
		
		private List<Joueur> Joueurs;

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

		public List<Joueur> getJoueurs() {
			return Joueurs;
		}

		public void setJoueurs(List<Joueur> joueurs) {
			Joueurs = joueurs;
		}



		
		
		
		
}
