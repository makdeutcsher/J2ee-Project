package com.smartgen.smartgen.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "documentdemandes")
public class DocumentDemande extends AuditModel {

	
	@Id
    @GeneratedValue(generator = "documents_demandes_generator")
    @SequenceGenerator(
            name = "documents_demandes_generator",
            sequenceName = "documents_sequence",
            initialValue = 1000
    )
    private Long id;
	
	@NotBlank
	private String question;
	
	@NotBlank
    private String nom;

	private String chemin;

	public DocumentDemande() {
		
		super();
	}
	
	public DocumentDemande(@NotBlank String question, @NotBlank String nom, String chemin) {
		super();
		this.id = id;
		this.question = question;
		this.nom = nom;
		this.chemin = chemin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
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