package org.formation.mediatheque.controller;

import org.formation.mediatheque.json.MembreViews;
import org.formation.mediatheque.model.Membre;
import org.formation.mediatheque.service.MembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/user")
public class UserController {
	
	
	@Autowired
	MembreService membreService;
	
	
	@GetMapping()
	public Authentication displayUser() {
		
		return SecurityContextHolder.getContext().getAuthentication();
	}

	@PostMapping("/login")
	public ResponseEntity<Membre> authentification(@RequestBody   @JsonView(MembreViews.Credentials.class) Membre credentials){
		try {
			Membre m =membreService.authentif(credentials.getEmail(),credentials.getPassword());
			return ResponseEntity.ok(m);
			
		}catch(Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
}

//	
	//@Autowired
	//MembreService membreService;
	
	
//	@PostMapping("/login")
//	public Authentication displayUser() {
//		
//		return SecurityContextHolder.getContext().getAuthentication();
//		}
	
//	@PostMapping("/login")
//	public ResponseEntity<Membre> authentification(@RequestBody   @JsonView(MembreViews.Credentials.class) Membre credentials){
//		try {
//			Membre m =membreService.authentif(credentials.getEmail(),credentials.getPassword());
//			return ResponseEntity.ok(m);
//			
//		}catch(Exception e) {
//			return ResponseEntity.notFound().build();
//		}
//	}
//}	

