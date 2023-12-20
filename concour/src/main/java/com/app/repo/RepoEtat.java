package com.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Entities.EtatCandidate;
@Repository
public interface  RepoEtat  extends JpaRepository<EtatCandidate, Integer>{
	public List<EtatCandidate> findByEtat(String etat);
}