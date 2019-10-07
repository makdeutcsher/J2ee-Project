package com.smartgen.smartgen.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role  extends AuditModel{

	

	@Id
    @GeneratedValue(generator = "roles_generator")
    @SequenceGenerator(
            name = "roles_generator",
            sequenceName = "users_generator",
            initialValue = 1000
    )
    private Long id;
	
	@NotBlank
    private String name;
	
	@NotBlank
    private String permissions;
	
public Role() {
	super();
}
	public Role(String name, String permissions) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.permissions =permissions;
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
	public String getPermissions() {
		return permissions;
	}
	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}
	
	
	
}
