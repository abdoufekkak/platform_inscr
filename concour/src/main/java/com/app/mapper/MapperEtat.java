package com.app.mapper;

import org.springframework.stereotype.Component;

import com.app.Entities.EtatCandidate;
import com.app.dto.DtoRequestEtat;
import com.app.dto.DtoRespenceEtat;
@Component

public class MapperEtat {

	public EtatCandidate requestEtatToEtat(DtoRequestEtat dtoRequestEtat) {
		EtatCandidate condidate = new EtatCandidate();
		
		condidate.setEtat(dtoRequestEtat.getEtat());
		condidate.getConcour().setId(dtoRequestEtat.getId_concour());
		condidate.setId_etudiant(dtoRequestEtat.getId_etudiant());
		return condidate;

	}
		public DtoRespenceEtat etatToResponseEtat(EtatCandidate  etat) {
			DtoRespenceEtat dtoRespenceEtat =new DtoRespenceEtat();
			
			dtoRespenceEtat.setId_etudiant(etat.getId_etudiant());
			dtoRespenceEtat.setId_concour(etat.getConcour().getId());
			dtoRespenceEtat.setEtat(etat.getEtat());
			return dtoRespenceEtat;
		} 
}
