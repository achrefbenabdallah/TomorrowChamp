package com.example.demo.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.JoueurResponse;
import com.example.demo.dto.PartieRequest;
import com.example.demo.dto.PartieResponse;
import com.example.demo.models.Joueur;
import com.example.demo.models.Partie;
import com.example.demo.repositories.PartieRepository;

@Service
public class PartieServiceImpl implements PartieService{
	
	private PartieRepository repoPartie;
	private ModelMapper mapper;
	
	@Autowired
	public PartieServiceImpl(PartieRepository repoPartie,ModelMapper mapper) {
		super();
		this.repoPartie = repoPartie;
		this.mapper=mapper;
	}

	@Override
	public List<Partie> getAllParties() {
		return repoPartie.findAll();
	}

	@Override
	public PartieResponse createPartieEntity(PartieRequest partie) {
	
		Partie entity = mapper.map(partie, Partie.class);
		Partie newEntity=repoPartie.save(entity);
		PartieResponse res=new PartieResponse(partie.getStade(),partie.getJoueurs());
		return res;
	}

	@Override
	public PartieResponse getPartieById(long id) {
		Optional<Partie> opt=repoPartie.findById(id);
		Partie entity;
		if(opt.isPresent())
			entity = opt.get();
		else
			throw new NoSuchElementException("Partie with this id is not found");
		
		return mapper.map(entity, PartieResponse.class);
	}

	@Override
	public PartieResponse deletePartieById(long id) {
		
		return null;
	}

	@Override
	public PartieResponse saveOrUpdate(long id, PartieRequest partie) {
		
		return null;
	}

}
