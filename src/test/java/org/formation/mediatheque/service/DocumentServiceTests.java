package org.formation.mediatheque.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.List;

import org.formation.mediatheque.model.Document;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DocumentServiceTests {
	
	
	@Autowired
	DocumentService documentService;
	
	
	@Test
	void testfindAllDocumentDisponible() {
		int nbreDocDispo=0;
		List<Document> ret = documentService.findAllDocumentDisponible();
		for(Document d : ret) {
			if (d.getNbreExemplaires()>0) {
				nbreDocDispo+=1;
			}
		}
		System.out.println("nbreDocDispo "+ nbreDocDispo);
		assertEquals(nbreDocDispo,documentService.findAllDocumentDisponible().size());
		
		
	}
	
	@Test
	void testFindAllDocumentByParution() {
		Date date = new Date();
		date.setMonth(date.getMonth()-1);
		int nbreNewCdDispo=0;
		List<Document> ret = documentService.findAllDocumentByParution("cd");
		for(Document d : ret) {
			if ((d.getNbreExemplaires()>0) && (date.before(d.getDateParution() )) ) {
				nbreNewCdDispo+=1;
			}
		}
		System.out.println("nbreNewCdDispo  "+ nbreNewCdDispo);
		assertEquals(nbreNewCdDispo, documentService.findAllDocumentByParution("cd").size());
		
	}

}
