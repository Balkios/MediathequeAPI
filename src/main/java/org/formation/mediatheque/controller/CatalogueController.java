package org.formation.mediatheque.controller;

import java.util.List;

import org.formation.mediatheque.json.DocumentViews;
import org.formation.mediatheque.model.Document;
import org.formation.mediatheque.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

@CrossOrigin(origins = "http://localhost:4200") 
@RestController
@RequestMapping("/api/catalogue")
public class CatalogueController {
	
	
	@Autowired
	DocumentService documentService ;
	
	@GetMapping("/document")
	@JsonView(DocumentViews.DocumentView.class)
	public ResponseEntity<List<Document>> findAllDocumentDisponible(){
		List<Document> docsDispo= documentService.findAllDocumentDisponible();
		return ResponseEntity.ok(docsDispo);
	}
	
	@GetMapping("/new/cd")
	@JsonView(DocumentViews.CdView.class)
	public ResponseEntity<List<Document>> findAllNewCd(){
		List<Document> newCdDispo= documentService.findAllDocumentByParution("cd");
		return ResponseEntity.ok(newCdDispo);
	}
	
	@GetMapping("/new/dvd")
	@JsonView(DocumentViews.DvdView.class)
	public ResponseEntity<List<Document>> findAllNewDvd(){
		List<Document> newCdDispo= documentService.findAllDocumentByParution("dvd");
		return ResponseEntity.ok(newCdDispo);
	}
	
	@GetMapping("/new/livre")
	@JsonView(DocumentViews.LivreView.class)
	public ResponseEntity<List<Document>> findAllNewLivre(){
		List<Document> newCdDispo= documentService.findAllDocumentByParution("livre");
		return ResponseEntity.ok(newCdDispo);
	}

}
