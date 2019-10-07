package com.smartgen.smartgen.repository;


import com.smartgen.smartgen.model.Glossaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GlossaireRepository extends JpaRepository<Glossaire,Long> {

}


