package com.smartgen.smartgen.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "documents")
public class Document extends AuditModel {

	
	@Id
    @GeneratedValue(generator = "documents_generator")
    @SequenceGenerator(
            name = "documents_generator",
            sequenceName = "documents_sequence",
            initialValue = 1000
    )
    private Long id;
	
	public Document(@NotBlank String nom, String chemin) {
		super();
		this.nom = nom;
		this.chemin = chemin;
	}
	
	public Document() {
		super();
	}

	@NotBlank
    private String nom;
	
	private String chemin;
	

	/**
	 * Getters and Setters
	 */
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}	
	
	public String getChemin() {
		return chemin;
	}

	public void setChemin(String chemin) {
		this.chemin = chemin;
	}
		
}
