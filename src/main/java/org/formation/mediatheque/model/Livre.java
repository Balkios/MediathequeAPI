package org.formation.mediatheque.model;

import javax.persistence.Entity;

import org.formation.mediatheque.json.DocumentViews;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Entity
@Data
public class Livre extends Document {
	
	@JsonView(DocumentViews.LivreView.class)
	private String ecrivain;
	
	@JsonView(DocumentViews.LivreView.class)
	private long numeroIsbn;

}
