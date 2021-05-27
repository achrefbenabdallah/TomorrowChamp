package com.example.demo.dto;

import java.util.List;

import com.example.demo.models.Joueur;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
public class PartieResponse {
	
	private String stade;
	private List<Joueur> joueurs;

	public PartieResponse() {
		super();
	}

	public PartieResponse(String stade, List<Joueur> joueurs) {
		super();
		this.stade = stade;
		this.joueurs = joueurs;
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
