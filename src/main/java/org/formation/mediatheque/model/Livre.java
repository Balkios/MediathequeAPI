package org.formation.mediatheque.model;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Livre extends Document {
	
	private String ecrivain;
	
	private long numeroIsbn;

}
