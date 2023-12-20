package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Entities.Inscription;
public interface RepoInscription  extends JpaRepository<Inscription, Integer>{
	

}
