package com.propertymangement.app.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.propertymangement.app.user.entity.Permission;
import com.propertymangement.app.user.service.PermissionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @PostMapping(value="/save-permission")
    public Permission savePermission(@RequestBody Permission permission) {
        if(permission.getPermissionName()!=null){
            return permissionService.savePermission(permission.getPermissionName());
        }
        return null;
    } 
    
}
