package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exception.Exception500;
import com.app.Entities.Concours;
import com.app.dto.DTOResponseConcours;
import com.app.dto.DtoRequestConcours;
import com.app.mapper.MapperConcours;

import com.app.repo.RepoConcours;

import com.app.exception.Exception404;

@Service
public class ServiceAConcours {

	@Autowired
    private RepoConcours repoConcours;
    @Autowired
    private MapperConcours mapperConcours;
    public List <Concours> getConcours(){
		return repoConcours.findAll();
	}
	
	public DTOResponseConcours AddConcours(DtoRequestConcours dtoRequestConcours){
		Concours concours= mapperConcours.requestConcoursToConcours(dtoRequestConcours);
	concours=repoConcours.save(concours);
		 return mapperConcours.concoursToResponseDto(concours);
	}
	
	public void deleteConcours(Integer Id) {
		Concours concours2=repoConcours.findById(Id).orElse(null);
		if(concours2==null) { throw new Exception404("concours not found");}
	   repoConcours.delete(concours2);
	}
	
	
	public DTOResponseConcours ModifyConcours(DtoRequestConcours dtoRequestConcours,Integer Id){
		Concours concours2=repoConcours.findById(Id).orElse(null);
		if(concours2==null) { throw new Exception404("concours not found"); }
		Concours concours= mapperConcours.requestConcoursToConcours(dtoRequestConcours);
	
		return mapperConcours.concoursToResponseDto(repoConcours.save(concours));
	}
	
}
