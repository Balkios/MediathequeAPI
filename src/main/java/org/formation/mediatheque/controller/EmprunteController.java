package org.formation.mediatheque.controller;

import org.formation.mediatheque.exceptions.SizeEmprunteException;
import org.formation.mediatheque.model.Emprunte;
import org.formation.mediatheque.repository.EmprunteRepository;
import org.formation.mediatheque.service.EmprunteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/empruntes")
public class EmprunteController {
	
	@Autowired
	EmprunteService emprunteService;
	
	
	
	// effectuer une emprunte
	@PostMapping("/")
	public Emprunte createEmprunte(@RequestBody Emprunte e)throws SizeEmprunteException {
		Emprunte emp = emprunteService.effectuerEmprunte(e.getIdMembre(), e.getIdDocument());
		return emp;
	}
	
	// restituer une emprunte
	@DeleteMapping("/{idEmprunte}")
	public ResponseEntity<Void>  deleteEmprunte(@PathVariable long idEmprunte) {
		//emprunteService.
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}

}
