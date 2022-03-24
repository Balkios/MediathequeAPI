package org.formation.mediatheque.service;

import java.util.Date;
import java.util.Optional;

import org.formation.mediatheque.model.Document;
import org.formation.mediatheque.model.Emprunte;
import org.formation.mediatheque.model.Membre;
import org.formation.mediatheque.repository.DocumentRepository;
import org.formation.mediatheque.repository.EmprunteRepository;
import org.formation.mediatheque.repository.MembreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmprunteService {
	
	@Autowired
	DocumentRepository  documentRepository;
	
	@Autowired
	MembreRepository membreRepository;
	
	@Autowired
	EmprunteRepository emprunteRepository;
	
	
	//effectuer une emprunte
//	public Emprunte effectuerEmprunte(long idMembre, long idDocument) {
//		
//		Membre  m= membreRepository.findById(idMembre).get();
//		
//		Document d =documentRepository.findById(idDocument).get();
//		d.setNbreExemplaires(d.getNbreExemplaires()-1);
//		Emprunte e=new Emprunte();
//		e.setDateCreation(new Date());
//		e.setDocument(d);
//		e.setMembre(m);
//		e.setDateRetour(new Date(new Date().getTime()+1000*60*60*24*7));// ajouter 7 jours pour la per
//		
//		
//		return emprunteRepository.save(e);
//		
//		
//	}

}
