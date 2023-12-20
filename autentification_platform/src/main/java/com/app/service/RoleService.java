package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.DtoRequestRolle;
import com.app.dto.DtoResponseRole;
import com.app.entities.Role;
import com.app.exception.Exception500;
import com.app.mapper.MapperRolle;
import com.app.repo.RepoRole;
@Service
public class RoleService {

	@Autowired
	RepoRole roleRepo;
	@Autowired 
	MapperRolle mapperRole;
	
	public List<Role>  gelAll() {
		return  roleRepo.findAll();
	}
	public  DtoResponseRole addRole(DtoRequestRolle dtoRequestRolle) {	
	Role role=roleRepo.findByRoleName(dtoRequestRolle.getRoleName());
	if(role!=null) { throw new Exception500("rolle already exist"); }
	 role=	mapperRole.reuestRoleToleRole(dtoRequestRolle);
	role=roleRepo.save(role);
	 return mapperRole.roleToResponseDto(role);
	}
	
	public void deleteRole(Integer Id) {
		Role role=roleRepo.findById(Id).orElse(null);
		if(role==null) { throw new com.app.exception.Exception404("admin not found");}
		roleRepo.delete(role);
	}
	
	
}
