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

import com.app.Entities.EtatCandidate;
import com.app.dto.DtoRequestEtat;
import com.app.dto.DtoRespenceEtat;




@RestController
@RequestMapping("Etat/")
public class WebEtat {

	@Autowired
	com.app.service.ServiceEtat serviceEtat;
	
	@GetMapping("")
	public ResponseEntity<List<EtatCandidate>> getEtats() {
	    List<EtatCandidate> listEtats = serviceEtat.getEtats(); 
	    return new ResponseEntity<>(listEtats, HttpStatus.OK);
	}
	@PostMapping("")
	public ResponseEntity<DtoRespenceEtat > addEtat(@RequestBody DtoRequestEtat dtoRequestEtat) {
		DtoRespenceEtat  etatResponseDto=	serviceEtat.addEtat(dtoRequestEtat);
		return  new ResponseEntity<>(etatResponseDto,HttpStatus.CREATED);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteEtat(@PathVariable Integer id) {
		serviceEtat.deleteEtat(id);
        return ResponseEntity.noContent().build();
}

}