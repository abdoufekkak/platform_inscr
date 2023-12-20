package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DTO.DtoRequestFiliere;
import com.app.DTO.DtoResponseFiliere;
import com.app.Exception.Exception404;
import com.app.Exception.Exception500;
import com.app.Mappers.MapperFiliere;
import com.app.entities.Filiere;
import com.app.reposotiries.RepoFiliere;



@Service
public class ServiceFiliere {
	@Autowired
	private RepoFiliere repoFiliere;
	@Autowired
	private MapperFiliere mapperFiliere ;

	public List <Filiere> getFiliere(){
		return repoFiliere.findAll();
	}
	
	public DtoResponseFiliere AddFiliere(DtoRequestFiliere dtoRequestFiliere){
		Filiere filiere2=repoFiliere.findByNom(dtoRequestFiliere.getNom());
		if(filiere2!=null) {throw new Exception500("filiere already exist"); }
		Filiere filiere= mapperFiliere.requestFiliereToFiliere(dtoRequestFiliere);
		
		filiere=repoFiliere.save(filiere);
		 return mapperFiliere.filiereToResponseDto(filiere);
	}
	
	public void deleteFiliere(Integer Id) {
		Filiere filiere2=repoFiliere.findById(Id).orElse(null);
		if(filiere2==null) { throw new Exception404("filiere not found") ;}
	   repoFiliere.delete(filiere2);
	}
	
	public DtoResponseFiliere ModifyFiliere(DtoRequestFiliere dtoRequestFiliere,Integer Id){
		Filiere filiere2=repoFiliere.findById(Id).orElse(null);
		if(filiere2==null) { throw new Exception404("filiere not found"); }
		Filiere filiere= mapperFiliere.requestFiliereToFiliere(dtoRequestFiliere);
		filiere.setId(Id);
	
		return mapperFiliere.filiereToResponseDto(repoFiliere.save(filiere));
	}
}
