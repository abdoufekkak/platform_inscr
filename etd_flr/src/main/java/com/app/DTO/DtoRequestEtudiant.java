package com.app.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DtoRequestEtudiant {
    private String nom;
    private String prenom;
    private Integer age;
}
