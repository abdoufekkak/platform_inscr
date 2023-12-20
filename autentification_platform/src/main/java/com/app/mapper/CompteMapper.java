package com.app.mapper;

import org.springframework.stereotype.Component;

import com.app.dto.CompteRequestDto;
import com.app.dto.CompteResponseDto;
import com.app.dto.DtoRequestRolle;
import com.app.dto.DtoResponseRole;
import com.app.entities.Compte;
import com.app.entities.Role;
@Component
public class CompteMapper {
	public Compte requestCompteToCompte(CompteRequestDto dtoRequestCompte) {
		Compte compte = new Compte();
		
		compte.setMail(dtoRequestCompte.getMail());
		compte.setUserName(dtoRequestCompte.getUserName());
		compte.setMotPass(dtoRequestCompte.getMotPass());
		return compte;

	}
		public CompteResponseDto compteToResponseDto(Compte compte) {
			CompteResponseDto dtoResponseCompte =new CompteResponseDto();
			
			dtoResponseCompte.setMail(compte.getMail());
			dtoResponseCompte.setUserName(compte.getMail());
			dtoResponseCompte.setMotPass(compte.getMotPass());
			dtoResponseCompte.setId(compte.getId());
			return dtoResponseCompte;
		} 

}
