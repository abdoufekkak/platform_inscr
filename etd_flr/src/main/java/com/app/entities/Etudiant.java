package com.app.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer Id;
    @Column(nullable = false)
	public String nom;
    @Column(nullable = false)
	public String prenom;
	@Column()
	public Integer age;
	@Column()
	public Integer ID_Compte;
	@ManyToOne
	@JoinColumn(name = "filiere_id",        referencedColumnName = "id",
 insertable = false, updatable = false)
	@JsonBackReference

   private Filiere filiere;
}
