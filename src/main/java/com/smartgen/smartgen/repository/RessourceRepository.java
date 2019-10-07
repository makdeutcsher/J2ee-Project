package com.smartgen.smartgen.repository;

import com.smartgen.smartgen.model.Ressource;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RessourceRepository extends JpaRepository<Ressource,Long> {
	
	public Ressource findByNom(String nom);
	
}


