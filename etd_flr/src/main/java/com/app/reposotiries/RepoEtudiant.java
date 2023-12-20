package com.app.reposotiries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Etudiant;

@Repository
public interface RepoEtudiant extends JpaRepository<Etudiant, Integer>{

	  public Etudiant findByNom(String Name);        
	  public Etudiant findByPrenom(String Prenom);
}