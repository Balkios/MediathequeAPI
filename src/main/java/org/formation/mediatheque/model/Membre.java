package org.formation.mediatheque.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
//@Table(name="USERS")
@Data
public class Membre {
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)// id en autoIncrémentation
	private long id;
	
	@NotNull
	private String email;
	
	@NotNull
	private String password;
	
	private String nom;
	
	private String prenom;
	
	@OneToMany(mappedBy = "membre")// bi
	//@Size(max = 3, min = 1)
	private Set<Emprunte> emprunte = new HashSet<Emprunte>();

	public Membre(@NotNull String email, @NotNull String motDePasse, String nom, String prenom) {
		//super();
		this.email = email;
		this.password = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
	}
	public Membre() {}
	
	

}
