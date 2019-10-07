package com.smartgen.smartgen.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.apache.tomcat.util.json.JSONParser;
import org.hibernate.annotations.LazyCollection;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.databind.util.JSONPObject;

@Entity
@Table(name = "demandes")
public class Demande extends AuditModel {
	
	@Id
    @GeneratedValue(generator = "demandes_generator")
    @SequenceGenerator(
            name = "demandes_generator",
            sequenceName = "demandes_sequence",
            initialValue = 1
    )
    private Long id;
	
	private String etat;

	@NotBlank
    private String description;
	  
	


	@NotBlank
    private String rs_organisme;
	
	@NotBlank
	private String nom_organisme;
	

	@NotBlank
	private String adresse_organisme;
	
	
	@NotBlank
	private String email_organisme;
	

	
	@NotBlank
	private String telephone_organisme;
	
	
	@NotBlank
    private String type_permis;
	
	
	public long userId;
	
	
	
	@OneToMany(fetch= FetchType.EAGER)
	@JoinColumn( name = "demandeId")
	public List<DocumentDemande> dossierDemande;


	@ManyToMany
	@JoinTable(
			name = "ressource_demande", 
			joinColumns = @JoinColumn(name = "demande_id"), 
			inverseJoinColumns = @JoinColumn(name = "ressource_id"))
	public List<Ressource> ressources;


	public Demande() {
		super();
		
	}
	
	
	public Demande( @NotBlank String description, @NotBlank String rs_organisme, @NotBlank String nom_organisme,
			@NotBlank String adresse_organisme, @NotBlank String email_organisme, @NotBlank String telephone_organisme,
			@NotBlank String type_permis, long userId, List<DocumentDemande> dossierDemande, List<Ressource> ressources) {
		super();

		this.description = description;
		this.rs_organisme = rs_organisme;
		this.nom_organisme = nom_organisme;
		this.adresse_organisme = adresse_organisme;
		this.email_organisme = email_organisme;
		this.telephone_organisme = telephone_organisme;
		this.type_permis = type_permis;
		this.userId = userId;
		this.etat="en cours";
		this.dossierDemande = dossierDemande;
		this.ressources = ressources;
	}


	// getters and setters
	
	
	public Long getId() {
		return id;
	}


	public String getEtat() {
		return etat;
	}


	public void setEtat(String etat) {
		this.etat = etat;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getRS_organisme() {
		return rs_organisme;
	}


	public void setRS_organisme(String rS_organisme) {
		rs_organisme = rS_organisme;
	}


	public String getNom_organisme() {
		return nom_organisme;
	}


	public void setNom_organisme(String nom_organisme) {
		this.nom_organisme = nom_organisme;
	}


	public String getAdresse_organisme() {
		return adresse_organisme;
	}


	public void setAdresse_organisme(String adresse_organisme) {
		this.adresse_organisme = adresse_organisme;
	}


	public String getEmail_organisme() {
		return email_organisme;
	}


	public void setEmail_organisme(String email_organisme) {
		this.email_organisme = email_organisme;
	}


	public String getTelephone_organisme() {
		return telephone_organisme;
	}


	public void setTelephone_organisme(String telephone_organisme) {
		this.telephone_organisme = telephone_organisme;
	}


	public String getType_permis() {
		return type_permis;
	}


	public void setType_permis(String type_permis) {
		this.type_permis = type_permis;
	}


	public List<DocumentDemande> getDossierDemande() {
		return dossierDemande;
	}


	public void setDossierDemande(List<DocumentDemande> dossierDemande) {
		this.dossierDemande = dossierDemande;
	}


	public List<Ressource> getRessources() {
		return ressources;
	}


	public void setRessources(List<Ressource> ressources) {
		this.ressources = ressources;
	}
	
	

	
	
	
}