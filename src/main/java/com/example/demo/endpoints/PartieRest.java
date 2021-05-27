package com.example.demo.endpoints;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.JoueurRequest;
import com.example.demo.dto.JoueurResponse;
import com.example.demo.dto.PartieRequest;
import com.example.demo.dto.PartieResponse;
import com.example.demo.models.Joueur;
import com.example.demo.models.Partie;
import com.example.demo.services.JoueurService;
import com.example.demo.services.PartieService;

@RestController
@RequestMapping("/api/parties")
public class PartieRest {

private PartieService service;
	
	@Autowired
	public PartieRest(PartieService service) {
		super();
		this.service = service;
	}
	
	@GetMapping
	public List<Partie> getAll(){
		return service.getAllParties();
	}
	
	@GetMapping("/{id}")
	public PartieResponse getPartieById(@PathVariable("id") long id){
		return service.getPartieById(id);
	}
	
	
	@PostMapping
	public PartieResponse createPartieEntity(@Valid @RequestBody PartieRequest partie){
		return service.createPartieEntity(partie);
	}
	
	@DeleteMapping("/{id}")
	public PartieResponse deletePartieById(@PathVariable("id") long id) {
		return service.deletePartieById(id);
	}
	
	/*@PutMapping("/{id}")
	public JoueurResponse updateJoueur(@PathVariable("id") long id, @RequestBody JoueurRequest request) {
		return service.saveOrUpdate(id, request);
	}*/
	
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}
