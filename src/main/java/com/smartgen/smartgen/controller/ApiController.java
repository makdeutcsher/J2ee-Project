package com.smartgen.smartgen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartgen.smartgen.repository.ClasseRepository;
import com.smartgen.smartgen.repository.DemandeRepository;
import com.smartgen.smartgen.repository.DocApaRepository;
import com.smartgen.smartgen.repository.DocumentRepository;
import com.smartgen.smartgen.repository.DomaineRepository;
import com.smartgen.smartgen.repository.InstitutionRepository;
import com.smartgen.smartgen.repository.RessourceRepository;
import com.smartgen.smartgen.repository.RoleRepository;
import com.smartgen.smartgen.repository.UserRepository;
import com.smartgen.smartgen.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

@RestController
public class ApiController {
	
	
	@Autowired
    private InstitutionRepository institutionRepository;
	
	@Autowired
    private DomaineRepository domaineRepository;
	
	@Autowired
    private ClasseRepository classeRepository;
	
	@Autowired
    private RessourceRepository ressourceRepository;
	
	@Autowired
    private DocumentRepository documentRepository;
	
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
    private RoleRepository roleRepository;
	
	@Autowired
	private DemandeRepository demandeRepository;
	
	@GetMapping("/api/institution")
    public List<Institution> greeting() {
        return institutionRepository.findAll();
    }
	
	@GetMapping("/api/user")
    public List<User> user() {
        return userRepository.findAll();
    }
	
	@PostMapping("/api/institution/delete/{id}")
	public List<Institution> deleteInstitution(@PathVariable("id") Long id) {
	    Institution institution = institutionRepository.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Institut invalide Id:" + id));
	    institutionRepository.delete(institution);
	    return institutionRepository.findAll();
	}
	
	@PostMapping("/institution/add")
	public Institution addInstitution(@RequestBody Institution institution) {
		institutionRepository.save(institution);
	    return institution;
	}
	

	@GetMapping("/classes")
    public List<Classe> getDomaines() {
        return classeRepository.findAll();
    }
	
	@GetMapping("/byname")
    public Ressource getRG() {
        return ressourceRepository.findByNom("bahaa");
    }
	
	@GetMapping("/api/ressources")
    public List<Ressource> getRessources() {
        return ressourceRepository.findAll();
    }
	
	@PostMapping("/api/ressource/delete/{id}")
	public List<Ressource> deleteRessource(@PathVariable("id") Long id) {
	    Ressource ressource = ressourceRepository.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Institut invalide Id:" + id));
	    ressourceRepository.delete(ressource);
	    return ressourceRepository.findAll();
	}
	
	@GetMapping("/api/role/delete/{id}")
	public List<Role> deleteRole(@PathVariable("id") Long id) {
	    Role role = roleRepository.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Institut invalide Id:" + id));
	    roleRepository.delete(role);
	    return roleRepository.findAll();
	}
	
	@PostMapping("/api/ressource/add")
	public Ressource addRessource(@RequestBody Ressource ressource) {
		ressourceRepository.save(ressource);
	    return ressource;
	}
	
	@GetMapping("/docs")
    public List<Demande> getDocuements() {
        return demandeRepository.findAll();
    }
    
	
	@PostMapping("/api/demande/delete/{id}")
	public List<Demande> deleteDemande(@PathVariable("id") Long id) {
	    Demande demande = demandeRepository.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Demande invalid Id:" + id));
	    demandeRepository.delete(demande);
	    return demandeRepository.findAll();
	}
	
	@PostMapping("/api/demande/accept/{id}")
	public List<Demande> accepterDemande(@PathVariable("id") Long id) {
	    Demande demande = demandeRepository.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Demande invalid Id:" + id));
	    demande.setEtat("Approuvée");
	    demandeRepository.save(demande);
	    return demandeRepository.findAll();
	}
	
	@PostMapping("/api/demande/refuse/{id}")
	public List<Demande> refuserDemande(@PathVariable("id") Long id) {
	    Demande demande = demandeRepository.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Demande invalid Id:" + id));
	    demande.setEtat("Refusée");
	    demandeRepository.save(demande);
	    return demandeRepository.findAll();
	}
	
	@Autowired
	private DocApaRepository docApaRepository;
	
	@PostMapping("/api/docapa/delete/{id}")
	public List<DocApa> deleteDocApa(@PathVariable("id") Long id) {
	    DocApa ressource = docApaRepository.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Institut invalide Id:" + id));
	    docApaRepository.delete(ressource);
	    return docApaRepository.findAll();
	}
	
}


