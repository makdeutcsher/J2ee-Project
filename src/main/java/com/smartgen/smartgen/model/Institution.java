package com.smartgen.smartgen.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "institutions")
public class Institution extends AuditModel {
	@Id
    @GeneratedValue(generator = "institution_generator")
    @SequenceGenerator(
            name = "institution_generator",
            sequenceName = "institution_sequence",
            initialValue = 1000
    )
    private Long id;
	
	public Institution(@NotBlank String nom_institution, @NotBlank String adresse, @NotBlank String email,
			@NotBlank String tel, @NotBlank String statut, @NotBlank String description, long domaineId) {
		super();
		this.nom_institution = nom_institution;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
		this.statut = statut;
		this.description = description;
		this.domaineId = domaineId;
	}
	
	public Institution() {
		super();
	}

	@NotBlank
    private String nom_institution;
	
	@NotBlank
    private String adresse;

	@NotBlank
    private String email;
	
	@NotBlank
    private String tel;
	
	@NotBlank
    private String statut;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	/*
	@ManyToOne(fetch = FetchType.LAZY, optional = false )
	@JoinColumn(name = "id", insertable = false, updatable = false )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Domaine domaine;

	public Domaine getDomaine() {
		return domaine;
	}

	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}
	*/
    public long domaineId;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom_institution() {
		return nom_institution;
	}

	public void setNom_institution(String nom_institution) {
		this.nom_institution = nom_institution;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
