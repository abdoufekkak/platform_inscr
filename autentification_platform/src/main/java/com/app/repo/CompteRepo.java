package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Compte;



public interface CompteRepo extends JpaRepository<Compte, Integer>{
    public Compte findByUserName(String userName);        
    public Compte findByMail(String mail);        
}

