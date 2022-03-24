package org.formation.mediatheque.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.ManyToAny;

import lombok.Data;

@Entity
@Data
public class Emprunte {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="document_id") // clé étranger 
	private Document document;
	
	@ManyToOne
	@JoinColumn(name="membre_id")// clé étranger 
	private Membre membre;
	
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	
	@Temporal(TemporalType.DATE)
	private Date dateRetour;
	
	@Transient // non mappé dans la base 
	private long idMembre;
	
	@Transient
	private long idDocument;
	
	
	

}
