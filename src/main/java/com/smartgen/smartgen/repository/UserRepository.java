package com.smartgen.smartgen.repository;


import com.smartgen.smartgen.model.User;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	User findByEmail(String email);
//	User findById(Long id);

}


