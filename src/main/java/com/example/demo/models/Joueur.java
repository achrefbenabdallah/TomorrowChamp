package com.example.demo.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.Getter;

@Entity
@Data
@Getter
public class Joueur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nom;
	private String prenom;
	private String adresse;
	private String password;
	private String nationalite;
	private boolean disponibilite;
	
	@OneToOne(mappedBy ="joueur")
	private Caracteristique caracteristique;
	
	@OneToMany(mappedBy = "joueur", cascade = CascadeType.REMOVE)
	private List<Video> videos;
	
	@ManyToMany(mappedBy = "joueurs", cascade = CascadeType.ALL)
	private List<Partie> parties;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Scout scout;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Caracteristique getCaracteristique() {
		return caracteristique;
	}

	public void setCaracteristique(Caracteristique caracteristique) {
		this.caracteristique = caracteristique;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public List<Partie> getParties() {
		return parties;
	}

	public void setParties(List<Partie> parties) {
		this.parties = parties;
	}

	public Scout getScout() {
		return scout;
	}

	public void setScout(Scout scout) {
		this.scout = scout;
	}

	


	
}
