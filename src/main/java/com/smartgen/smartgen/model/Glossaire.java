package com.smartgen.smartgen.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "glossaires")
public class Glossaire extends AuditModel {

	@Id
    @GeneratedValue(generator = "glossaires_generator")
    @SequenceGenerator(
            name = "glossaires_generator",
            sequenceName = "glossaires_sequence",
            initialValue = 1000
    )
    private Long id;
	
	@NotBlank
    private String name;

	@NotBlank
	@Column(name="description", length=512)
    private String description;

	
	public Glossaire() {
		super();
	}
	
	public Glossaire(String name, String description) {
		this.description = description; 
		this.name =name;
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	

}
