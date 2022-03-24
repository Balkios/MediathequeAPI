package org.formation.mediatheque.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.formation.mediatheque.model.Cd;
import org.formation.mediatheque.model.Document;
import org.formation.mediatheque.model.Dvd;
import org.formation.mediatheque.model.Livre;
import org.formation.mediatheque.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {
	
	@Autowired
	DocumentRepository documentRepository;
	
	
	
	public List<Document> findAllDocumentDisponible() {
		List<Document> ret =new ArrayList<>();
		for(Document d : documentRepository.findDocumentDisponible()) {
			ret.add(d);
		}
		return ret;
	}
	
	
	public List<Document> findAllDocumentByParution(String clazz){
		Date currenteDate = new Date();
		currenteDate.setMonth(currenteDate.getMonth()-1);
		
		switch(clazz) {
		
		case "cd" : {
			List<Document> ret =new ArrayList<>();
			for(Document d : documentRepository.findDocumentByDateDisponibleParution(currenteDate)) {
				if(d instanceof Cd)
				ret.add(d);
			}
			return ret;
				
		}
		
		case "dvd" : {
			List<Document> ret =new ArrayList<>();
			for(Document d : documentRepository.findDocumentByDateDisponibleParution(currenteDate)) {
				if(d instanceof Dvd)
				ret.add(d);
			}
			return ret;
				
		}
		case "livre" : {
			List<Document> ret =new ArrayList<>();
			for(Document d : documentRepository.findDocumentByDateDisponibleParution(currenteDate)) {
				if(d instanceof Livre)
				ret.add(d);
			}
			return ret;
				
		}
		default:
			return documentRepository.findDocumentByDateDisponibleParution(currenteDate);
		}
		
		
		
		
	}
	

}
