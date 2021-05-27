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

import com.example.demo.dto.ScoutRequest;
import com.example.demo.dto.ScoutResponse;

import com.example.demo.models.Scout;

import com.example.demo.services.ScoutService;

@RestController
@RequestMapping("/api/scouts")
public class ScoutRest {
	
	private ScoutService service;
	

	@Autowired
	public ScoutRest(ScoutService service) {
		super();
		this.service = service;
	}
	
	@GetMapping
	public List<Scout> getAll(){
		return service.getAllScouts();
	}
	
	@GetMapping("/{id}")
	public ScoutResponse getScoutById(@PathVariable("id") long id){
		return service.getScoutById(id);
	}
	
	/*@PostMapping("/{id1}/{id}")
	public String setScoutInJoueur(@PathVariable("id1")long idJoueur, @PathVariable("id") long idScout) {
		return service.setScoutInJoueur(idJoueur, idScout);
		
	}*/
	
	
	@PostMapping
	public ScoutResponse createScoutEntity(@Valid @RequestBody ScoutRequest scout){
		return service.createScoutEntity(scout);
	}
	
	@DeleteMapping("/{id}")
	public ScoutResponse deleteScoutById(@PathVariable("id") long id) {
		return service.deleteScoutById(id);
	}
	
	@PutMapping("/{id}")
	public ScoutResponse updateScout(@PathVariable("id") long id, @RequestBody ScoutRequest request) {
		return service.saveOrUpdate(id, request);
	}
	
	
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

}
