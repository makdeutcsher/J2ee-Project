package com.smartgen.smartgen.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "ressources")
public class Ressource extends AuditModel {
	
	@Id
    @GeneratedValue(generator = "ressource_generator")
    @SequenceGenerator(
            name = "ressource_generator",
            sequenceName = "ressource_sequence",
            initialValue = 1000
    )
    private Long id;
	
	@Column(columnDefinition = "TEXT")
    private String description;
	

	@NotBlank
	@Column(unique=true)
    private String nom;

	@NotBlank
    private String image;
	
	@NotBlank
    private String region;
	
	@NotBlank
    private String caracteristiques;
	
    public long classeId;
	
	@OneToMany(fetch = FetchType.EAGER )
	@JoinColumn( name = "ressourceId")
	public List<Document> documents;
	


	
	
	public Ressource(String description, @NotBlank String nom, @NotBlank String image, @NotBlank String region,
			@NotBlank String caracteristiques, long classeId) {
		super();
		this.description = description;
		this.nom = nom;
		this.image = image;
		this.region = region;
		this.caracteristiques = caracteristiques;
		this.classeId = classeId;
	}
	
	public Ressource() {
		super();
	}
	
	
	
	/**
	 * Getters and Setters
	 */

	public Long getId() {
		return id;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCaracteristiques() {
		return caracteristiques;
	}

	public void setCaracteristiques(String caracteristiques) {
		this.caracteristiques = caracteristiques;
	}
	

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	

	
}
