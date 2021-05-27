package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Caracteristique {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String position;
	private String piedfort;
	private int hauteur;
	private double poids;
	private int physique;
	private int vitesse;
	private int defense;
	private int attaque;
	private int dribble;
	private int pass;
	private int tir;
	
	
	@OneToOne
	private Joueur joueur;
	
	
}
