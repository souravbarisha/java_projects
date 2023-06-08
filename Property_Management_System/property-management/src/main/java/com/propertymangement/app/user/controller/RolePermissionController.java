package com.propertymangement.app.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.propertymangement.app.user.dto.RolePermissionMapRequestDto;
import com.propertymangement.app.user.entity.Permission;
import com.propertymangement.app.user.entity.RolePermission;
import com.propertymangement.app.user.service.RolePermissionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/role-permission")
public class RolePermissionController {

    @Autowired
    private RolePermissionService rolePermissionService;
    
    @PostMapping(value="/map-role-permission")
    // public String mapRoleAndPermission(@RequestBody Integer roleId, List<Permission>permissions) {
        public String mapRoleAndPermission(@RequestBody RolePermissionMapRequestDto rolePermissionMapRequestDto) {
        if(rolePermissionMapRequestDto.getRoleId()!=null && !rolePermissionMapRequestDto.getPermissions().isEmpty()){
            return rolePermissionService.mapRoleAndPermisssion(rolePermissionMapRequestDto)? "Successfully mapped": "enter correct info";
        }
        return "Please enter the Role Id and permissions";
    }
    
}
