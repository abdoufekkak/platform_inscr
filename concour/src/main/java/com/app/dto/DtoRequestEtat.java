package com.app.dto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DtoRequestEtat {
	
		private String etat;
		private Integer id_concour;
		private Integer id_etudiant;
	}

