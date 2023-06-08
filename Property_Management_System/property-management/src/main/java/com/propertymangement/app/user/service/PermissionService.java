package com.propertymangement.app.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.propertymangement.app.user.entity.Permission;
import com.propertymangement.app.user.repository.PermissionRepository;

@Service
public class PermissionService {
    
    @Autowired
    private PermissionRepository permissionRepository;

    public Permission savePermission(String permissionName){
    	Permission existingPermission = permissionRepository.findBypermissionName(permissionName);
    	if(existingPermission == null) {
    	
        Permission newPermission = new Permission();
        newPermission.setPermissionName(permissionName);
        return permissionRepository.save(newPermission);
    	}
        return null;
    }
}
