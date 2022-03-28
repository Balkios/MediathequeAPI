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

import org.formation.mediatheque.json.EmpruntViews;
import org.formation.mediatheque.json.MembreViews;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Entity
//@Table(name="USERS")
@Data
public class Membre {
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)// id en autoIncrémentation
	@JsonView(EmpruntViews.EmprunteByMembreView.class)
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
	private Set<Emprunt> emprunte = new HashSet<Emprunt>();
	
	@Override
	public int hashCode() {// code bas niveau // si on veut modifier methode equals il faut modifier la méthode hashCode
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {// true si les objets sont égaux 
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Membre other = (Membre) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Membre(@NotNull String email, @NotNull String motDePasse, String nom, String prenom) {
		//super();
		this.email = email;
		this.password = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
	}
	public Membre() {}
	
	

}
