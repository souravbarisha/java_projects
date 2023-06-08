package com.propertymangement.app.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.propertymangement.app.user.entity.Role;
import com.propertymangement.app.user.repository.RoleRepository;

@Service
public class RoleService {
  
	@Autowired 
    private RoleRepository roleRepository;
    
    public Role saveRole(String rolname){

        Role newRole = new Role();
        newRole.setRoleName(rolname);
        return roleRepository.save(newRole);
    }
	
}
