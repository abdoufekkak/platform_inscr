package com.app.service;

import java.util.*;

import javax.sound.midi.SysexMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.DTOResponseAdmin;
import com.app.dto.DtoRequestAdmin;
import com.app.entities.Admin;
import com.app.entities.Role;
import com.app.exception.Exception404;
import com.app.exception.Exception500;
import com.app.mapper.MapperAdmin;
import com.app.repo.RepoAdmin;
import com.app.repo.RepoRole;



@Service
public class ServiceAdmin {
	@Autowired
	private RepoAdmin repoAdmin;
	@Autowired
	private RepoRole rollrepo;
	@Autowired
	private MapperAdmin mapperAdmin ;
	public List <Admin> getAdmin(){
		return repoAdmin.findAll();
	}
	
	public DTOResponseAdmin AddAdmin(DtoRequestAdmin dtoRequestAdmin){
		Admin admin2=repoAdmin.findByUsername(dtoRequestAdmin.getUsername());
		if(admin2!=null) { throw new Exception500("admin already exist"); }
		Admin admin= mapperAdmin.requestAdminToAdmin(dtoRequestAdmin);
		 admin=repoAdmin.save(admin);
		 return mapperAdmin.adminToResponseDto(admin);
	}

	public void deleteAdmin(Integer Id) {
		Admin admin2=repoAdmin.findById(Id).orElse(null);
		if(admin2==null) { throw new Exception404("admin not found");}
	   repoAdmin.delete(admin2);
	}
	
	public DTOResponseAdmin ModifyAdmin(DtoRequestAdmin dtoRequestAdmin,Integer Id){
		Admin admin2=repoAdmin.findById(Id).orElse(null);
		if(admin2==null) { throw new Exception404("admin not found"); }
		Admin admin= mapperAdmin.requestAdminToAdmin(dtoRequestAdmin);
		admin.setId(Id);
		return mapperAdmin.adminToResponseDto(repoAdmin.save(admin));
	}
	public DTOResponseAdmin AssignRole( String username,String Rollname) {
		Admin admin2=repoAdmin.findByUsername(username);
		if(admin2==null) throw  new Exception404("admin not found");
       Role role =rollrepo.findByRoleName(Rollname);
       System.out.println(Rollname);
		if(role==null) throw  new Exception404("role not found");
		if(admin2.getRoles()!=null) {
			for(int i=0;i<admin2.getRoles().size();i++) {
				if(admin2.getRoles().get(i).getRoleName().equals(Rollname)) {
					 throw  new Exception404("role est deja  assignie");
				}
			}
		}
		admin2.getRoles().add(role);
	return	mapperAdmin.adminToResponseDto(repoAdmin.save(admin2));	
		
	}
	
}