package org.formation.mediatheque.controller;

import org.formation.mediatheque.model.Emprunte;
import org.formation.mediatheque.repository.EmprunteRepository;
import org.formation.mediatheque.service.EmprunteService;
import org.springframework.beans.factory.annotation.Autowired;
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
	public Emprunte CreateEmprunte(@RequestBody Emprunte e) {
		Emprunte emp = emprunteService.effectuerEmprunte(e.getIdMembre(), e.getIdDocument());
		return emp;
	}
	
	

}
