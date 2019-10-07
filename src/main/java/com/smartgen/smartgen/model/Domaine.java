package com.smartgen.smartgen.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "domaines")
public class Domaine extends AuditModel {

	@Id
    @GeneratedValue(generator = "domaines_generator")
    @SequenceGenerator(
            name = "domaines_generator",
            sequenceName = "domaines_sequence",
            initialValue = 1000
    )
    private Long id;
	
	@NotBlank
    private String domaine;

	public Long getId() {
		return id;
	}
	

	@OneToMany(fetch = FetchType.EAGER )
	@JoinColumn( name = "domaineId")
	public List<Institution> instituitions;

	public List<Institution> getInstituitions() {
		return instituitions;
	}

	public void setInstituitions(List<Institution> instituitions) {
		this.instituitions = instituitions;
	}
	 
	public void setId(Long id) {
		this.id = id;
	}

	public String getDomaine() {
		return domaine;
	}

	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}
}
