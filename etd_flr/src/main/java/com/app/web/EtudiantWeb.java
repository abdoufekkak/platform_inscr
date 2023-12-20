package com.app.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FeignClient.EtdCompte;
import com.app.DTO.CompteResponseDto;
import com.app.DTO.DtoRequestEtudiant;
import com.app.DTO.DtoRespenseEtudiant;
import com.app.entities.Etudiant;
import com.app.services.EtudiantService;

@RestController
@RequestMapping("etudiant/")
public class EtudiantWeb {
	@Autowired
	EtudiantService etudiantService;
	@Autowired
	EtdCompte etdCompte;
	@GetMapping("")
	public ResponseEntity<List<Etudiant>> etdCompte() {
	    List<Etudiant> listRoles = etudiantService.getAll(); 
	    return new ResponseEntity<>(listRoles, HttpStatus.OK);
	}
	@GetMapping("{id}")
	public ResponseEntity<CompteResponseDto> getEtudiants(@PathVariable Integer id) {
		System.out.print(etdCompte.getCompte(id).toString());
	    return new ResponseEntity<>(etdCompte.getCompte(id), HttpStatus.OK);
	}
	@PostMapping("")
	public ResponseEntity<DtoRespenseEtudiant > addEtudiant(@RequestBody DtoRequestEtudiant dtoRequestCompte) {
		DtoRespenseEtudiant compteResponseDto=	etudiantService.addCompte(dtoRequestCompte);
		return  new ResponseEntity<>(compteResponseDto,HttpStatus.CREATED);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteEtudiant(@PathVariable Integer id) {
		etudiantService.deleteEtudiant(id);
        return ResponseEntity.noContent().build();
}
}
