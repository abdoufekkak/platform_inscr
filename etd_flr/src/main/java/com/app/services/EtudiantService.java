package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Mappers.MapperEtudiant;
import com.app.entities.Etudiant;
import com.app.entities.Filiere;
import com.app.DTO.DtoRequestEtudiant;
import com.app.DTO.DtoRespenseEtudiant;
import com.app.Exception.Exception404;
import com.app.Exception.Exception500;
import com.app.reposotiries.RepoEtudiant;

@Service
public class EtudiantService {

	@Autowired
	RepoEtudiant etudiantRepo;
	@Autowired 
	MapperEtudiant mapperEtudiant;
	
	public void deleteEtudiant(Integer id ){
		Etudiant etudiant = etudiantRepo.findById(id).orElse(null); 
		if(etudiant==null) { throw new Exception404("etudiant not found");}
		etudiantRepo.delete(etudiant);	
		}
	public List<Etudiant> getAll(){
		return etudiantRepo.findAll();
	}
	public  DtoRespenseEtudiant addCompte(DtoRequestEtudiant dtoRequestEtudiant) {	
		
		Etudiant etudiant=	mapperEtudiant.requestEtudiantToEtudiant(dtoRequestEtudiant);
		etudiant=etudiantRepo.save(etudiant);
		 return mapperEtudiant.EtudiantToEtudiantResponseDto(etudiant);
		}
}
