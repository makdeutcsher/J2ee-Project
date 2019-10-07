package com.smartgen.smartgen.repository;

import com.smartgen.smartgen.model.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution,Long> {
	List<Institution> findByDomaineId(Long domaineId);
	
}
