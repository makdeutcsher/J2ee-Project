package com.smartgen.smartgen.repository;

import com.smartgen.smartgen.model.Domaine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomaineRepository extends JpaRepository<Domaine,Long> {

}


