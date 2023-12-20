package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Role;

@Repository
public interface RepoRole extends JpaRepository<Role, Integer>{

	public Role findByRoleName(String username);
}
