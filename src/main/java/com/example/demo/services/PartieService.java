package com.example.demo.services;

import java.util.List;
import com.example.demo.dto.PartieRequest;
import com.example.demo.dto.PartieResponse;
import com.example.demo.models.Partie;

public interface PartieService {
	
	List<Partie> getAllParties();
	PartieResponse createPartieEntity(PartieRequest partie);
	PartieResponse getPartieById(long id);
	PartieResponse deletePartieById(long id);
	PartieResponse saveOrUpdate(long id,PartieRequest partie);

}
