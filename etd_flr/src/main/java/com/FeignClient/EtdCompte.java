package com.FeignClient;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.app.DTO.CompteResponseDto;

@FeignClient(name = "autentification")
public interface EtdCompte {
	
    @GetMapping("/compte/{id}")
 public CompteResponseDto   getCompte(@PathVariable(name ="id") Integer id);
}

