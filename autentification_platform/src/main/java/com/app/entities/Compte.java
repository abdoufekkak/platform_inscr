package com.app.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Compte implements Serializable{
	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer Id;
    @Column(unique = true,nullable = false)
	public String mail;
    @Column(nullable = false)
	public String motPass;
	@Column(unique = true,nullable = false)
	public String userName;
	 @ManyToMany
	    private List<Role> roles = new ArrayList<>();
}
