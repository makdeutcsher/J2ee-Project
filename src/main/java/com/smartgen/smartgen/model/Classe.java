package com.smartgen.smartgen.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "classes")
public class Classe extends AuditModel {

	
	@Id
    @GeneratedValue(generator = "classes_generator")
    @SequenceGenerator(
            name = "classes_generator",
            sequenceName = "classes_sequence",
            initialValue = 1000
    )
    private Long id;
	
	@NotBlank
    private String nom;
	
	private String description;
	
	@OneToMany(fetch = FetchType.EAGER )
	@JoinColumn( name = "classeId")
	public List<Ressource> ressources;
	
	

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
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Ressource> getRessources() {
		return ressources;
	}

	public void setInstituitions(List<Ressource> ressources) {
		this.ressources = ressources;
	}
	 
	

	
}
