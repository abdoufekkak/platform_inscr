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

import com.app.dto.CompteRequestDto;
import com.app.dto.CompteResponseDto;
import com.app.dto.DTOResponseAdmin;
import com.app.dto.RoleToAdmin;
import com.app.entities.Compte;
import com.app.service.CompteService;

@RestController
@RequestMapping("compte/")
public class CompteWeb {
	@Autowired
	CompteService compteService;
	
	@GetMapping("")
	public ResponseEntity<List<Compte>> getRolles() {
	    List<Compte> listRoles = compteService.getAll(); 
	    return new ResponseEntity<>(listRoles, HttpStatus.OK);
	}
	@GetMapping("{id}")
	public ResponseEntity<CompteResponseDto> getCOMBid(@PathVariable Integer id) {
	CompteResponseDto compte = compteService.getById(id); 
	    return new ResponseEntity<>(compte, HttpStatus.OK);
	}
	@PostMapping("")
	public ResponseEntity<CompteResponseDto > addRolle(@RequestBody CompteRequestDto dtoRequestCompte) {
		CompteResponseDto compteResponseDto=	compteService.addCompte(dtoRequestCompte);
		return  new ResponseEntity<>(compteResponseDto,HttpStatus.CREATED);
	}
	@PostMapping("ass")
	public ResponseEntity<CompteResponseDto > rolletoadmin(@RequestBody RoleToAdmin roleToAdmin ) {
		System.out.println(roleToAdmin.getUsername()+"  "+roleToAdmin.getRollname());
		CompteResponseDto dtoResponseAdmin = compteService.AssignRole(roleToAdmin.getUsername(),roleToAdmin.getRollname());
		return  new ResponseEntity<>(dtoResponseAdmin,HttpStatus.CREATED);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteCompte(@PathVariable Integer id) {
		compteService.deleteCompte(id);
	        return ResponseEntity.noContent().build();
	}
}
