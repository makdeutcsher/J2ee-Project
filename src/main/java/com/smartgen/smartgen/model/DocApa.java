package com.smartgen.smartgen.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "apadocs")
public class DocApa extends AuditModel {

	
	@Id
    @GeneratedValue(generator = "apadocs_generator")
    @SequenceGenerator(
            name = "apadocs_generator",
            sequenceName = "apadocs_sequence",
            initialValue = 1000
    )
    private Long id;
	
	public DocApa(@NotBlank String nom, String chemin) {
		super();
		this.nom = nom;
		this.chemin = chemin;
	}
	
	public DocApa() {
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
