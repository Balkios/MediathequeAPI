package org.formation.mediatheque.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.formation.mediatheque.json.EmprunteViews;
import org.formation.mediatheque.json.MembreViews;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Entity
//@Table(name="USERS")
@Data
public class Membre {
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)// id en autoIncrémentation
	@JsonView(EmprunteViews.EmprunteByMembreView.class)
	private long id;
	
	@NotNull
	@JsonView(MembreViews.Credentials.class)
	private String email;
	
	@NotNull
	@JsonView(MembreViews.Credentials.class)
	private String password;
	
	//@JsonIgnore
	private String nom;
	
	//@JsonIgnore
	private String prenom;
	
	@OneToMany(mappedBy = "membre",fetch = FetchType.LAZY)// bi
	@Size(max = 3, min = 1)
	@JsonIgnore
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
