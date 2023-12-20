package com.app.reposotiries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Filiere;


@Repository
public interface RepoFiliere extends JpaRepository<Filiere, Integer>{
	
	public Filiere findByNom(String nom);
}
