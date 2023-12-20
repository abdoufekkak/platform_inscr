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

import com.app.dto.DtoRequestRolle;
import com.app.dto.DtoResponseRole;
import com.app.service.RoleService;
import com.app.entities.Role;


@RestController
@RequestMapping("role/")
public class RolleWeb {
	@Autowired
	RoleService roleService;
	
	@GetMapping("")
	public ResponseEntity<List<Role>> getRolles() {
	    List<Role > listRoles = roleService.gelAll(); 
	    return new ResponseEntity<>(listRoles, HttpStatus.OK);
	}
	@PostMapping("")
	public ResponseEntity<DtoResponseRole > addRolle(@RequestBody DtoRequestRolle dtoRequestRolle) {
		DtoResponseRole dtoResponserolle=	roleService.addRole(dtoRequestRolle);
		return  new ResponseEntity<>(dtoResponserolle,HttpStatus.CREATED);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteRole(@PathVariable Integer id) {
		roleService.deleteRole(id);
	        return ResponseEntity.noContent().build();
	}
}
