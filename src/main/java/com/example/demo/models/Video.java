package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Video {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long id;
	 private String name;
	 private String longeur;
	 private String format;
	 
	 @ManyToOne
	 private Joueur joueur;
}
