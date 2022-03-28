package org.formation.mediatheque.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.formation.mediatheque.exceptions.SizeEmpruntException;
import org.formation.mediatheque.model.Document;
import org.formation.mediatheque.model.Emprunt;
import org.formation.mediatheque.model.Membre;
import org.formation.mediatheque.repository.DocumentRepository;
import org.formation.mediatheque.repository.EmpruntRepository;
import org.formation.mediatheque.repository.MembreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//@Transactional // deux operation persistence ==> commit et rollback 
@Service
public class EmpruntService {
	
	@Autowired
	DocumentRepository  documentRepository;
	
	@Autowired
	MembreRepository membreRepository;
	
	@Autowired
	EmpruntRepository emprunteRepository;
	
	
	//effectuer une emprunte et ne pas depasser 3 par membre 
	public Emprunt effectuerEmprunte(long idMembre, long idDocument) throws SizeEmpruntException {
		
		Membre m= membreRepository.findById(idMembre).get();// Optional<Membre>
		System.out.println( " nbre emrunte de ce membre "+m.getEmprunte().size());
		//Emprunte e1=new Emprunte();
		
		if(m.getEmprunte().size()<3) {
		Document d= documentRepository.findById(idDocument).get();
		//d.setDisponible(false);
		d.setNbreExemplaires(d.getNbreExemplaires()-1);
		Emprunt e=new Emprunt();
		e.setDateCreation(new Date());
		e.setDocument(d);
		e.setMembre(m);
		e.setDateRetour(new Date(new Date().getTime()+1000*60*60*24*7));
		
		
		return emprunteRepository.save(e);}
		
		 throw new SizeEmpruntException();
		 
	
		
	}
	
	


	// restituer une emprunte
	public void supprimeEmprunte(long idEmprunte) {
		Optional<Emprunt> e = emprunteRepository.findById(idEmprunte);
		emprunteRepository.deleteById(e.get().getId());
		documentRepository.restituerDocumentById(e.get().getDocument().getId());
	}
	//Read All empruntes de membre par son id 
	public List<Emprunt> findAllEmprunteByIdMembre(long id){
		return emprunteRepository.findByMembreId(id);
	}
	
	


}
