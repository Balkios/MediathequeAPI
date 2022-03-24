package org.formation.mediatheque.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.formation.mediatheque.json.DocumentViews;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Entity
@Data
public class Dvd extends Document {
	
	
	@JsonView(DocumentViews.DvdView.class)
	private String realisateur;
	
	@JsonView(DocumentViews.DvdView.class)
	private long duree;
	
	@JsonView(DocumentViews.DvdView.class)
	@Enumerated(EnumType.STRING)
	private DvdType type; // soit blue-ray ou normal

}
