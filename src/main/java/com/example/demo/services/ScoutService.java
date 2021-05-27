package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.ScoutRequest;
import com.example.demo.dto.ScoutResponse;
import com.example.demo.models.Scout;



public interface ScoutService {
	
	List<Scout> getAllScouts();
	ScoutResponse createScoutEntity(ScoutRequest scout);
	ScoutResponse getScoutById(long id);
	ScoutResponse deleteScoutById(long id);
	ScoutResponse saveOrUpdate(long id,ScoutRequest scout);
	
	//String setScoutInJoueur(long idJoueur ,long idScout );

}
