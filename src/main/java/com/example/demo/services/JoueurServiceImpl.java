package com.example.demo.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.JoueurRequest;
import com.example.demo.dto.JoueurResponse;
import com.example.demo.models.Joueur;
import com.example.demo.models.Scout;
import com.example.demo.repositories.JoueurRepository;
import com.example.demo.repositories.ScoutRepository;


@Service
public class JoueurServiceImpl implements JoueurService {
	
	private JoueurRepository repoJoueur;
	private ScoutRepository repoScout;
	private ModelMapper mapper;

	@Autowired
	public JoueurServiceImpl(JoueurRepository repoJoueur,ModelMapper mapper,ScoutRepository repoScout) {
		super();
		this.repoJoueur=repoJoueur;
		this.repoScout=repoScout;
		this.mapper=mapper;
	}
	
	
	@Override
	public List<Joueur> getAllJoueurs() {
		return repoJoueur.findAll();
	}

	@Override
	public JoueurResponse getJoueurById(long id) {

		Optional<Joueur> opt = repoJoueur.findById(id);
		Joueur entity;
		if(opt.isPresent())
			entity = opt.get();
		else
			throw new NoSuchElementException("Joueur with this id is not found");
		
		return mapper.map(entity, JoueurResponse.class);
	}

	@Override
	public JoueurResponse deleteJoueurById(long id) {
		Optional<Joueur> joueur = repoJoueur.findById(id);
		JoueurResponse res=new JoueurResponse(joueur.get().getNom(), joueur.get().getPrenom(), joueur.get().getAdresse(), joueur.get().getNationalite(), joueur.get().isDisponibilite());
		repoJoueur.deleteById(id);
		return res;

	}

	@Override
	public JoueurResponse saveOrUpdate(long id, JoueurRequest request) {
		
		JoueurResponse test = this.getJoueurById(id);
		
		if(request.getNom()!=null)
			test.setNom(request.getNom());
		if(request.getPrenom()!=null)
			test.setPrenom(request.getPrenom());
		if(request.getAdresse()!=null)
			test.setAdresse(request.getAdresse());
		if(request.getNationalite()!=null)
			test.setNationalite(request.getNationalite());
		
		Joueur newJoueur = mapper.map(test, Joueur.class);//mapper.map(test, Client.class);
		newJoueur.setId(id);
		newJoueur.setPassword(test.getPassword());
		repoJoueur.save(newJoueur);
		test.setNom(newJoueur.getNom());
		test.setPrenom(newJoueur.getPrenom());
		test.setAdresse(newJoueur.getAdresse());
		test.setNationalite(newJoueur.getNationalite());
	
		return test;
	}
	
	@Override
	public String setScoutInJoueur(long idJoueur, long idScout) {
		Optional<Joueur> joueur=repoJoueur.findById(idJoueur);
		if(joueur.get().isDisponibilite()) {
		Optional<Scout> scout=repoScout.findById(idScout);
		Scout newScout=mapper.map(scout, Scout.class);
		
		newScout.setId(idScout);
		//joueur.get().setScout(newScout);
		//joueur.get().setId(idJoueur);
		
		Joueur newJoueur = mapper.map(joueur, Joueur.class);
		newJoueur.setId(idJoueur);
		newJoueur.setAdresse(joueur.get().getAdresse());
		newJoueur.setDisponibilite(joueur.get().isDisponibilite());
		newJoueur.setCaracteristique(joueur.get().getCaracteristique());
		newJoueur.setNationalite(joueur.get().getNationalite());
		newJoueur.setNom(joueur.get().getNom());
		newJoueur.setPrenom(joueur.get().getPrenom());
		newJoueur.setPassword(joueur.get().getPassword());
		newJoueur.setScout(newScout);
		repoJoueur.save(newJoueur);
		//repoScout.save(mapper.map(scout, Scout.class));
		return "Joueur ajouter avec succes!";
		}else {
			return "Joueur indisponible !";
		}
	}


	@Override
	public JoueurResponse createJoueurEntity(JoueurRequest joueur) {
	
		Joueur entity = mapper.map(joueur, Joueur.class);
		Joueur newEntity = repoJoueur.save(entity);
		JoueurResponse res=new JoueurResponse(joueur.getNom(),joueur.getPrenom(),joueur.getAdresse(),joueur.getNationalite(),joueur.isDisponibilite());
		return res;
	}
	
	
}
