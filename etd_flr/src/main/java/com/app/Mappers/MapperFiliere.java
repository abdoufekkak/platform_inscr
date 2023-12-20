package com.app.Mappers;

import org.springframework.stereotype.Component;

import com.app.DTO.DtoRequestFiliere;
import com.app.DTO.DtoResponseFiliere;
import com.app.entities.Filiere;


@Component
public class MapperFiliere {
	  public Filiere requestFiliereToFiliere(DtoRequestFiliere dtoRequestFiliere) {
		   Filiere filiere=new Filiere();
		   filiere.setNom(dtoRequestFiliere.getNom());
		   return filiere;
	   }
	   public DtoResponseFiliere filiereToResponseDto(Filiere filiere) {
		   DtoResponseFiliere	dtoResponseFiliere =new DtoResponseFiliere();
		   dtoResponseFiliere.setNom(filiere.getNom());
		   dtoResponseFiliere.setId(filiere.getId());
	

			return dtoResponseFiliere;
		} 
}
