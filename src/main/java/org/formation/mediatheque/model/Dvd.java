package org.formation.mediatheque.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Data;

@Entity
@Data
public class Dvd extends Document {
	
	private String realisateur;
	
	private long duree;
	
	@Enumerated(EnumType.STRING)
	private DvdType type; // soit blue-ray ou normal

}
