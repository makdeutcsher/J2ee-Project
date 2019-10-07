package com.smartgen.smartgen.repository;

import com.smartgen.smartgen.model.Demande;
import com.smartgen.smartgen.model.DocumentDemande;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentDemandeRepository extends JpaRepository<DocumentDemande,Long> {
	
}