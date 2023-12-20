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

import com.app.Entities.Concours;
import com.app.dto.DTOResponseConcours;
import com.app.dto.DtoRequestConcours;
import com.app.service.ServiceAConcours;



@RestController
@RequestMapping("concours/")
public class WebConcours {
	@Autowired
	ServiceAConcours serviceConcours ;
	


	@GetMapping("")
	public ResponseEntity<List<Concours>> getConcours() {
	    List<Concours > concours = serviceConcours .getConcours (); 
	    return new ResponseEntity<>(concours, HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<DTOResponseConcours > addConcours(@RequestBody DtoRequestConcours dtoRequestConcours) {
		DTOResponseConcours dtoResponseConcours=	serviceConcours.AddConcours(dtoRequestConcours);
		return  new ResponseEntity<>(dtoResponseConcours,HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<DTOResponseConcours > modProf(@RequestBody DtoRequestConcours dtoRequestConcours,@PathVariable Integer id) {
		DTOResponseConcours dtoResponseConcours=	serviceConcours.ModifyConcours( dtoRequestConcours,id);
		return  new ResponseEntity<>(dtoResponseConcours,HttpStatus.OK);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<?> deletConcours(@PathVariable Integer id) {
			serviceConcours.deleteConcours(id);
	        return ResponseEntity.noContent().build();
	}

	
}
