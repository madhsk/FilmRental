package com.springboot.filmrentalstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.springboot.filmrentalstore.model.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
	@Query("SELECT r FROM Role r WHERE r.role_name = ?1")
	Role findByRoleName(String roleName);
}