package org.formation.mediatheque.controller;

import java.util.List;

import org.formation.mediatheque.exceptions.SizeEmprunteException;
import org.formation.mediatheque.json.EmprunteViews;
import org.formation.mediatheque.model.Emprunte;
import org.formation.mediatheque.repository.EmprunteRepository;
import org.formation.mediatheque.service.EmprunteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/api/empruntes")
public class EmprunteController {
	
	@Autowired
	EmprunteService emprunteService;
	
	
	
	// effectuer une emprunte
	@PostMapping("/")
	public Emprunte createEmprunte(@RequestBody @JsonView(EmprunteViews.EmprunteView.class) Emprunte e)throws SizeEmprunteException {
		Emprunte emp = emprunteService.effectuerEmprunte(e.getIdMembre(), e.getIdDocument());
		return emp;
	}
	
	// restituer une emprunte
	@DeleteMapping("/{idEmprunte}")
	public ResponseEntity<Void>  deleteEmprunte(@PathVariable long idEmprunte) {
		try {
			emprunteService.supprimeEmprunte(idEmprunte);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	//ReadALL emprunte
	@GetMapping("/membre/{idMembre}")
	@JsonView(EmprunteViews.EmprunteByMembreView.class)
	public List<Emprunte> findEmprunteByMembreId(@PathVariable Long idMembre){
		return emprunteService.findAllEmprunteByIdMembre(idMembre);
	}

}
