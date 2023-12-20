package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.CompteRequestDto;
import com.app.dto.CompteResponseDto;
import com.app.dto.DTOResponseAdmin;
import com.app.dto.DtoRequestRolle;
import com.app.dto.DtoResponseRole;
import com.app.entities.Admin;
import com.app.entities.Compte;
import com.app.entities.Role;
import com.app.exception.Exception404;
import com.app.exception.Exception500;
import com.app.mapper.CompteMapper;
import com.app.mapper.MapperRolle;
import com.app.repo.CompteRepo;
import com.app.repo.RepoRole;

@Service
public class CompteService {

	@Autowired
	CompteRepo compteRepo;
	@Autowired 
	CompteMapper mapperCompte;
	@Autowired
	private RepoRole rollrepo;
	public void deleteCompte(Integer id ){
		Compte compte = compteRepo.findById(id).orElse(null); 
		if(compte==null) { throw new com.app.exception.Exception404("compte not found");}
		compteRepo.delete(compte);	
		}
	public List<Compte> getAll(){
		return compteRepo.findAll();
	}
	public  CompteResponseDto addCompte(CompteRequestDto dtoRequestCompte) {	
		Compte compte=compteRepo.findByUserName(dtoRequestCompte.getUserName());
		Compte compte2=compteRepo.findByMail(dtoRequestCompte.getMail());
		if(compte!=null || compte2!=null) { throw new Exception500("compte already exist"); }
		compte=	mapperCompte.requestCompteToCompte(dtoRequestCompte);
		compte=compteRepo.save(compte);
		 return mapperCompte.compteToResponseDto(compte);
		}
	
	public CompteResponseDto AssignRole( String username,String Rollname) {
		Compte compte=compteRepo.findByUserName(username);
		if(compte==null) throw  new Exception404("admin not found");
       Role role =rollrepo.findByRoleName(Rollname);
       System.out.println(Rollname);
		if(role==null) throw  new Exception404("role not found");
		if(compte.getRoles()!=null) {
			for(int i=0;i<compte.getRoles().size();i++) {
				if(compte.getRoles().get(i).getRoleName().equals(Rollname)) {
					 throw  new Exception404("role est deja  assignie");
				}
			}
		}
		compte.getRoles().add(role);
	return	mapperCompte.compteToResponseDto(compteRepo.save(compte));	
		
	}
	public  CompteResponseDto getById(Integer Id) {
		Compte compte=compteRepo.findById(Id).orElse(null);
		if(compte==null) {
			 throw  new Exception404("compte not found");
		}
		return 	mapperCompte.compteToResponseDto(compte);

	}
	
}