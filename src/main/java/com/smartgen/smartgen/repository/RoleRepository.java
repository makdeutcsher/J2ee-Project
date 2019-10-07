package com.smartgen.smartgen.repository;


import com.smartgen.smartgen.model.Role;
import com.smartgen.smartgen.model.User;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
	Role findByName(String name);
	

}
