package org.formation.mediatheque.model;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Cd extends Document {
	
	private String artisteGroupe;
	
	private long duree;
	
	private long nbreTitres;

}
