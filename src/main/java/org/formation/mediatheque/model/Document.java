package org.formation.mediatheque.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.formation.mediatheque.json.DocumentViews;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Entity
@Data
@Inheritance(strategy=InheritanceType.JOINED)// creer Une table par classe
public class Document implements Serializable {
	
	private static final long serialVersionUID = 6590486482810196501L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(DocumentViews.DocumentView.class)
	private long id;
	
	@JsonView(DocumentViews.DocumentView.class)
	private String titre;
	
	@JsonView(DocumentViews.DocumentView.class)
	private long nbreExemplaires;
	
	@Temporal(TemporalType.DATE)
	@JsonView(DocumentViews.DocumentView.class)
	private Date dateParution;
	
	@JsonView(DocumentViews.DocumentView.class)
	private boolean disponible;// ajouter pour faciliter le seclect de document disponible 
	
	
	@OneToMany(mappedBy = "document")
	@JsonIgnore
	private Set<Emprunte> empruntes= new HashSet<Emprunte>();
	
	//Document('CD1', 3, '1987-08-15',true)
	
	

}
