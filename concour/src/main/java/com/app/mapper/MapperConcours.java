package com.app.mapper;


import org.springframework.stereotype.Component;


import com.app.Entities.Concours;
import com.app.dto.DTOResponseConcours;
import com.app.dto.DtoRequestConcours;


@Component

public class MapperConcours {
	public Concours requestConcoursToConcours(DtoRequestConcours dtoRequestConcours) {
		   Concours concours=new Concours();
		   concours.setLibelle(dtoRequestConcours.getLibelle());
		   concours.setJourPassage(dtoRequestConcours.getJourPassage());
		   concours.setNomSalle(dtoRequestConcours.getNomSalle());
		   concours.setDuree(dtoRequestConcours.getDuree());
		   concours.setEtat(dtoRequestConcours.getEtat());
		   concours.setMaxAge(dtoRequestConcours.getMaxAge());
		   concours.setMinNote(dtoRequestConcours.getMinNote());
		   concours.setHasBacLibre(dtoRequestConcours.getHasBacLibre());
		   concours.setCategorie(dtoRequestConcours.getCategorie());

		   return concours;
	}
	
	
	 public DTOResponseConcours concoursToResponseDto(Concours concours) {
		   DTOResponseConcours	dtoResponseConcours =new DTOResponseConcours();
		   dtoResponseConcours.setId(concours.getId());
		   dtoResponseConcours.setLibelle(concours.getLibelle());
		   dtoResponseConcours.setJourPassage(concours.getJourPassage());
		   dtoResponseConcours.setNomSalle(concours.getNomSalle());
		   dtoResponseConcours.setDuree(concours.getDuree());
		   dtoResponseConcours.setEtat(concours.getEtat());
		   dtoResponseConcours.setMaxAge(concours.getMaxAge());
		   dtoResponseConcours.setMinNote(concours.getMinNote());
		   dtoResponseConcours.setHasBacLibre(concours.getHasBacLibre());
		   dtoResponseConcours.setCategorie(concours.getCategorie());


			return dtoResponseConcours;
		} 
}
