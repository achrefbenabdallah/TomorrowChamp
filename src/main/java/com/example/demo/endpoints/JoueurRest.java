package com.example.demo.endpoints;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
import com.example.demo.models.Joueur;
import com.example.demo.services.JoueurService;

@RestController
@RequestMapping("/api/joueurs")
public class JoueurRest {
	
	private JoueurService service;
	
	@Autowired
	public JoueurRest(JoueurService service) {
		super();
		this.service = service;
	}
	
	@GetMapping
	public List<Joueur> getAll(){
		return service.getAllJoueurs();
	}
	
	@GetMapping("/{id}")
	public JoueurResponse getJoueurById(@PathVariable("id") long id){
		return service.getJoueurById(id);
	}
	
	
	@PostMapping
	public JoueurResponse createJoueurEntity(@Valid @RequestBody JoueurRequest joueur){
		return service.createJoueurEntity(joueur);
	}
	
	@DeleteMapping("/{id}")
	public JoueurResponse deleteJoueurById(@PathVariable("id") long id) {
		return service.deleteJoueurById(id);
	}
	
	@PutMapping("/{id}")
	public JoueurResponse updateJoueur(@PathVariable("id") long id, @RequestBody JoueurRequest request) {
		return service.saveOrUpdate(id, request);
	}
	
	@PutMapping("/{id1}/{id}")
	public String setScoutInJoueur(@PathVariable("id1")long idJoueur, @PathVariable("id") long idScout) {
		return service.setScoutInJoueur(idJoueur, idScout);
		
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

}
