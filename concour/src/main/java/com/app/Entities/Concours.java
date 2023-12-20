package com.app.Entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Concours implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer Id;
	private String libelle;
	private Date jourPassage;
	private String nomSalle;
	private Integer duree;
	private String etat;
	private Integer maxAge;
	private Integer minNote;
	private Boolean hasBacLibre;
	private String Categorie;
//	@JsonManagedReference

	@OneToMany(mappedBy = "concour", cascade = CascadeType.ALL)
    private List<Inscription> inscriptions;

	@OneToMany(mappedBy = "concour", cascade = CascadeType.ALL)
    private List<EtatCandidate> etatCandidate;
}
