package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entities.Admin;


public interface RepoAdmin extends JpaRepository<Admin, Integer>{
	
	public Admin findByUsername(String username);
	
	
}