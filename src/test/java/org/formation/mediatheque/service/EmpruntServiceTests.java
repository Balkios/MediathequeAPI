package org.formation.mediatheque.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.formation.mediatheque.exceptions.SizeEmpruntException;
import org.formation.mediatheque.model.Document;
import org.formation.mediatheque.model.Emprunt;
import org.formation.mediatheque.model.Membre;
import org.formation.mediatheque.repository.DocumentRepository;
import org.formation.mediatheque.repository.MembreRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmpruntServiceTests {
	
	@Autowired
	EmpruntService emprunteService;
	@Autowired
	MembreRepository membreRepository;
	@Autowired
	DocumentRepository documentRepository;
	
	@Test
	void testEffectuerEmprunte() throws SizeEmpruntException {
		Document d =documentRepository.findById(1L).get();
	       
        Membre m= membreRepository.findById(1L).get();
       
        //Emprunte e= emprunteService.effectuerEmprunte(m.getId(), d.getId());
       
       
        System.out.println(d.getNbreExemplaires());
       
        Emprunt emprunt = emprunteService.effectuerEmprunte(2, 1);
       
        System.out.println(emprunt.getDocument().getNbreExemplaires());
        //assertEquals(e.getDocument(),d);
        //assertEquals(1, e.getId());
        assertEquals(d.getNbreExemplaires()-1,emprunt.getDocument().getNbreExemplaires() );
        //assertEquals(1, m.getId());
		
		
	}

}
