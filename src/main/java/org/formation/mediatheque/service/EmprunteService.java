package org.formation.mediatheque.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.formation.mediatheque.exceptions.SizeEmprunteException;
import org.formation.mediatheque.model.Document;
import org.formation.mediatheque.model.Emprunte;
import org.formation.mediatheque.model.Membre;
import org.formation.mediatheque.repository.DocumentRepository;
import org.formation.mediatheque.repository.EmprunteRepository;
import org.formation.mediatheque.repository.MembreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//@Transactional // deux operation persistence ==> commit et rollback 
@Service
public class EmprunteService {
	
	@Autowired
	DocumentRepository  documentRepository;
	
	@Autowired
	MembreRepository membreRepository;
	
	@Autowired
	EmprunteRepository emprunteRepository;
	
	
	//effectuer une emprunte et ne pas depasser 3 par membre 
	public Emprunte effectuerEmprunte(long idMembre, long idDocument) throws SizeEmprunteException {
		
		Membre  m= membreRepository.findById(idMembre).get();
		if(m.getEmprunte().size()<3) {
			Document d =documentRepository.findById(idDocument).get();
			d.setNbreExemplaires(d.getNbreExemplaires()-1);
			Emprunte e=new Emprunte();
			e.setDateCreation(new Date());
			e.setDocument(d);
			e.setMembre(m);
			e.setDateRetour(new Date(new Date().getTime()+1000*60*60*24*7));// ajouter 7 jours (datedeRetour)
			//documentRepository.save(d);
			
			return emprunteRepository.save(e);
		}
		throw new SizeEmprunteException();
		
		
	}
	
	


	// restituer une emprunte
	public void supprimeEmprunte(long idEmprunte) {
		Optional<Emprunte> e = emprunteRepository.findById(idEmprunte);
		emprunteRepository.deleteById(e.get().getId());
		documentRepository.restituerDocumentById(e.get().getDocument().getId());
	}
	//Read All empruntes de membre par son id 
	public List<Emprunte> findAllEmprunteByIdMembre(long id){
		return emprunteRepository.findByMembreId(id);
	}
	
	


}
