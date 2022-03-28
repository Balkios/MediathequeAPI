package org.formation.mediatheque.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.formation.mediatheque.json.EmpruntViews;
import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Entity
@Data
public class Emprunt {
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(EmpruntViews.EmprunteByMembreView.class)
	private long id;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="document_id") // clé étranger 
	@JsonView(EmpruntViews.EmprunteByMembreView.class)
	private Document document;
	
	@ManyToOne
	@JoinColumn(name="membre_id")// clé étranger 
	@JsonIgnore
	private Membre membre;
	
	@Temporal(TemporalType.DATE)
	@JsonView(EmpruntViews.EmprunteByMembreView.class)
	private Date dateCreation;
	
	@Temporal(TemporalType.DATE)
	@JsonView(EmpruntViews.EmprunteByMembreView.class)
	private Date dateRetour;
	
	@Transient // non mappé dans la base 
	@JsonView(EmpruntViews.EmprunteView.class)
	private long idMembre;
	
	@Transient
	@JsonView(EmpruntViews.EmprunteView.class)
	private long idDocument;
	
	
	

}
