package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.JoueurRequest;
import com.example.demo.dto.JoueurResponse;
import com.example.demo.models.Joueur;

public interface JoueurService {
	List<Joueur> getAllJoueurs();
	JoueurResponse createJoueurEntity(JoueurRequest joueur);
	JoueurResponse getJoueurById(long id);
	JoueurResponse deleteJoueurById(long id);
	JoueurResponse saveOrUpdate(long id,JoueurRequest joueur);

	String setScoutInJoueur(long idJoueur ,long idScout );
}