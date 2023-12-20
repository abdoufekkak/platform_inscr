package com.app.dto;

import java.util.Date;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoRequestConcours {
	
	private String libelle;
	private Date jourPassage;
	private String nomSalle;
	private Integer duree;
	private String etat;
	private Integer maxAge;
	private Integer minNote;
	private Boolean hasBacLibre;
	private String Categorie;
}
