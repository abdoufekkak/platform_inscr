package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoResponseInscription {
	private Integer Id;
	private Integer  IdEtudiant;
    private Integer IdConcour;
}
