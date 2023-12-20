package com.app.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoRespenseEtudiant {
    private Integer Id;
    private String nom;
    private String prenom;
    private Integer age;
}
