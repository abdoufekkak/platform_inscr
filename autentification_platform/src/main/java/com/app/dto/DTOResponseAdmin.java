package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTOResponseAdmin {
	private Integer Id;
	private String nom;
	private String username;
	private String mdp;
}
