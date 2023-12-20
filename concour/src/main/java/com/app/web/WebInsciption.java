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

import com.app.Entities.Inscription;
import com.app.dto.DtoRequestInscription;
import com.app.dto.DtoResponseInscription;
import com.app.service.ServiceInscription;


@RestController
@RequestMapping("inscription/")
public class WebInsciption {

	@Autowired
	ServiceInscription serviceInscription;
	
	@GetMapping("")
	public ResponseEntity<List<Inscription>> etdCompte() {
	    List<Inscription> listRoles = serviceInscription.getAll(); 
	    return new ResponseEntity<>(listRoles, HttpStatus.OK);
	}
//	@GetMapping("{id}")
//	public ResponseEntity<CompteResponseDto> getEtudiants(@PathVariable Integer id) {
//		System.out.print(etdCompte.getCompte(id).toString());
//	    return new ResponseEntity<>(etdCompte.getCompte(id), HttpStatus.OK);
//	}
	@PostMapping("")
	public ResponseEntity<DtoResponseInscription > addEtudiant(@RequestBody DtoRequestInscription dtoRequestCompte) {
		System.out.println(dtoRequestCompte.getIdEtudiant());
		DtoResponseInscription compteResponseDto=	serviceInscription.addInscription(dtoRequestCompte);
		return  new ResponseEntity<>(compteResponseDto,HttpStatus.CREATED);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteEtudiant(@PathVariable Integer id) {
		serviceInscription.deleteEtudiant(id);
        return ResponseEntity.noContent().build();
}

}