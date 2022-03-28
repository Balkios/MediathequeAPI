package org.formation.mediatheque;

import java.util.Collection;
import java.util.HashSet;

import javax.validation.constraints.NotNull;

import org.formation.mediatheque.json.EmpruntViews;
import org.formation.mediatheque.json.MembreViews;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Data
public class CustomUserDetails extends User {
	
	private long id;
	
	private String email;
	

	private String password;
	
	
	private String nom;
	
	
	private String prenom;




	public CustomUserDetails(long id, String email, String password, String nom, String prenom) {
		super(email,password,new HashSet<>());
		this.id = id;
		this.email = email;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
	}
	

}
