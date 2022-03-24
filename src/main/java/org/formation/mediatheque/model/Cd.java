package org.formation.mediatheque.model;

import javax.persistence.Entity;

import org.formation.mediatheque.json.DocumentViews;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Entity
@Data
public class Cd extends Document {
	
	
	@JsonView(DocumentViews.CdView.class)
	private String artisteGroupe;
	
	@JsonView(DocumentViews.CdView.class)
	private long duree;
	
	@JsonView(DocumentViews.CdView.class)
	private long nbreTitres;

}
