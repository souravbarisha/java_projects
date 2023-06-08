package com.propertymangement.app.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.propertymangement.app.user.entity.Role;
import com.propertymangement.app.user.service.RoleService;

@RestController
public class RoleController {

	 @Autowired
	    private RoleService roleService;
	    
	    @PostMapping(value="/save-role")
	    public Role saveRole(@RequestBody Role role) {
	        if(role.getRoleName()!=null){
	        return roleService.saveRole(role.getRoleName());
	    }
	       return null;
	    }
}
