package com.smartgen.smartgen.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends AuditModel {

	@Id
    @GeneratedValue(generator = "users_generator")
    @SequenceGenerator(
            name = "users_generator",
            sequenceName = "users_generator",
            initialValue = 1000
    )
    private Long id;
	
	@NotBlank
    private String nom;
	
	@NotBlank
    private String prenom;
	
	@NotBlank
	@Column(unique=true)
    private String email;
	
	@NotBlank
    private String password;


	@OneToMany
    @JoinColumn(name = "userId") // we need to duplicate the physical information
    public List<Demande> demandes;
	
	
	@ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "roleId")
    public Role role;
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public User () {
		super();
	}
	public User (Long id ,String nom , String prenom, String email, String password){
		this.id=id;
		this.nom = nom ;
		this.prenom = prenom; 
		this.email = email;
		this.password = password;
	}
	public User (String nom , String prenom, String email, String password){
		
		this.nom = nom ;
		this.prenom = prenom; 
		this.email = email;
		this.password = password;
	}
		public User (String nom , String prenom, String email, String password, Role role) {
		this.nom = nom ;
		this.prenom = prenom; 
		this.email = email;
		this.password = password;
		this.role = role;
		
	}
	/** getters and setters **/
	
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	}

