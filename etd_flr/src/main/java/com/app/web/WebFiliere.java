package com.app.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTO.DtoRequestFiliere;
import com.app.DTO.DtoResponseFiliere;
import com.app.entities.Filiere;
import com.app.services.ServiceFiliere;




@RestController
@RequestMapping("filiere/")

public class WebFiliere {

	@Autowired
	ServiceFiliere serviceFiliere;
	
	@GetMapping("")
	public ResponseEntity<List<Filiere>> getFiliere() {
	    List<Filiere> filieres = serviceFiliere.getFiliere(); 
	    return new ResponseEntity<>(filieres, HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<DtoResponseFiliere > addProf(@RequestBody DtoRequestFiliere dtoRequestFiliere) {
		DtoResponseFiliere dtoResponseFiliere=	serviceFiliere.AddFiliere(dtoRequestFiliere);
		return  new ResponseEntity<>(dtoResponseFiliere,HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<DtoResponseFiliere > modProf(@RequestBody DtoRequestFiliere dtoRequestFiliere,@PathVariable Integer id) {
		DtoResponseFiliere dtoResponseFiliere=	serviceFiliere.ModifyFiliere( dtoRequestFiliere,id);
		return  new ResponseEntity<>(dtoResponseFiliere,HttpStatus.OK);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<?> deletFiliere(@PathVariable Integer id) {
			serviceFiliere.deleteFiliere(id);
	        return ResponseEntity.noContent().build();
	}
}
