package org.formation.mediatheque.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.List;

import org.formation.mediatheque.model.Document;
import org.formation.mediatheque.model.Emprunt;
import org.formation.mediatheque.service.EmpruntService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;


//@SpringBootTest // demarre toute l'apli
@DataJpaTest // demarre que c'est nec essaire pour le test
public class DocumentRepositoryTests {
	
	
	@Autowired
	DocumentRepository documentRepository;
	
	@Autowired
	EmpruntRepository emprunteRepository;
	
	@Autowired
	EmpruntService emprunteService;
	
	
	@Test
	void testFindDocumentDisponible() {
		//Document d = new Document();
		int nbreDocDispo=0;
		List<Document> ret = documentRepository.findDocumentDisponible();
		for(Document d : ret) {
			if (d.getNbreExemplaires()>0) {
				nbreDocDispo+=1;
			}
		}
		System.out.println("nbreDocDispo "+ nbreDocDispo);
		assertEquals(nbreDocDispo, documentRepository.findDocumentDisponible().size());
		
		
	}
	
	
	@Test
	void testFindDocumentDisponibleByDateParution() {
		Date date = new Date();
		date.setMonth(date.getMonth()-1);
		int nbreNewDocDispo=0;
		List<Document> ret = documentRepository.findDocumentDisponibleByDateParution(date);
		for(Document d : ret) {
			if ((d.getNbreExemplaires()>0) && (date.before(d.getDateParution() )) ) {
				nbreNewDocDispo+=1;
			}
		}
		System.out.println("nbreNewDocDispo  "+ nbreNewDocDispo);
		assertEquals(nbreNewDocDispo, documentRepository.findDocumentDisponibleByDateParution(date).size());
		
	}
//	@Test
//	void testRestituerDocumentById() {
//		Emprunte e =emprunteService.effectuerEmprunte(1, 1);
//		System.out.println("eeeeeeeeeeeeeeeeeeeee        "+e);
//		
//	}
	


}
