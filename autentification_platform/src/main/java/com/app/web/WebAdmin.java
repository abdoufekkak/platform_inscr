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

import com.app.dto.DTOResponseAdmin;
import com.app.dto.DtoRequestAdmin;
import com.app.dto.RoleToAdmin;
import com.app.entities.Admin;
import com.app.service.ServiceAdmin;



@RestController
@RequestMapping("admin/")
public class WebAdmin {
	@Autowired
	ServiceAdmin serviceAdmin ;
	public WebAdmin(ServiceAdmin serviceAdmin) {
		super();
		this.serviceAdmin = serviceAdmin;
	}


	@GetMapping("")
	public ResponseEntity<List<Admin>> getAdmin() {
	    List<Admin > admins = serviceAdmin .getAdmin (); 
	    return new ResponseEntity<>(admins, HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<DTOResponseAdmin > addAdmin(@RequestBody DtoRequestAdmin dtoRequestAdmin) {
		DTOResponseAdmin dtoResponseAdmin=	serviceAdmin.AddAdmin(dtoRequestAdmin);
		return  new ResponseEntity<>(dtoResponseAdmin,HttpStatus.CREATED);
	}
	@PostMapping("ass")
	public ResponseEntity<DTOResponseAdmin > rolletoadmin(@RequestBody RoleToAdmin roleToAdmin ) {
		System.out.println(roleToAdmin.getUsername()+"  "+roleToAdmin.getRollname());
		  DTOResponseAdmin dtoResponseAdmin = serviceAdmin.AssignRole(roleToAdmin.getUsername(),roleToAdmin.getRollname());
		return  new ResponseEntity<>(dtoResponseAdmin,HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<DTOResponseAdmin > modProf(@RequestBody DtoRequestAdmin dtoRequestAdmin,@PathVariable Integer id) {
		DTOResponseAdmin dtoResponseAdmin=	serviceAdmin.ModifyAdmin( dtoRequestAdmin,id);
		return  new ResponseEntity<>(dtoResponseAdmin,HttpStatus.OK);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<?> deletAdmin(@PathVariable Integer id) {
			serviceAdmin.deleteAdmin(id);
	        return ResponseEntity.noContent().build();
	}

}
