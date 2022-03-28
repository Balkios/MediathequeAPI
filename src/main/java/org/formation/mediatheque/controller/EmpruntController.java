package org.formation.mediatheque.controller;

import java.util.List;

import org.formation.mediatheque.exceptions.SizeEmpruntException;
import org.formation.mediatheque.json.EmpruntViews;
import org.formation.mediatheque.model.Emprunt;
import org.formation.mediatheque.repository.EmpruntRepository;
import org.formation.mediatheque.service.EmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/empruntes")
public class EmpruntController {
	
	@Autowired
	EmpruntService emprunteService;
	
	
	
	// effectuer une emprunte
	@PostMapping("/")
	public Emprunt createEmprunte(@RequestBody @JsonView(EmpruntViews.EmprunteView.class) Emprunt e)throws SizeEmpruntException {
		//Emprunte emp =  emprunteService.effectuerEmprunte(e.getIdMembre(), e.getIdDocument());
		return  emprunteService.effectuerEmprunte(e.getIdMembre(), e.getIdDocument());
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
	@JsonView(EmpruntViews.EmprunteByMembreView.class)
	public List<Emprunt> findEmprunteByMembreId(@PathVariable Long idMembre){
		return emprunteService.findAllEmprunteByIdMembre(idMembre);
	}

}
