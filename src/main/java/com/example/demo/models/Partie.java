package com.example.demo.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Partie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String stade;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "detailpartie")
	@JsonIgnore
	private List<Joueur> joueurs;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStade() {
		return stade;
	}

	public void setStade(String stade) {
		this.stade = stade;
	}

	public List<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}
	
	
	
}
