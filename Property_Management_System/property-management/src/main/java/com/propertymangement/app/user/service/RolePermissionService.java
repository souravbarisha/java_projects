package com.propertymangement.app.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.propertymangement.app.user.dto.RolePermissionMapRequestDto;
import com.propertymangement.app.user.entity.Permission;
import com.propertymangement.app.user.entity.Role;
import com.propertymangement.app.user.entity.RolePermission;
import com.propertymangement.app.user.repository.PermissionRepository;
import com.propertymangement.app.user.repository.RolePermissionRepository;
import com.propertymangement.app.user.repository.RoleRepository;

@Service
public class RolePermissionService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    public boolean mapRoleAndPermisssion(RolePermissionMapRequestDto rolePermissionMapRequestDto) {

        Role existingRole = roleRepository.findById(rolePermissionMapRequestDto.getRoleId()).orElse(null);
        RolePermission mapRolePermission = new RolePermission();

        if (existingRole != null) {
            for (Permission permission : rolePermissionMapRequestDto.getPermissions()) {
                Permission exPermission = permissionRepository.findBypermissionName(permission.getPermissionName());
                if(exPermission==null){
                    mapRolePermission.setPermission(permissionRepository.save(permission));
                }else{
                    mapRolePermission.setPermission(exPermission);
                }
                mapRolePermission.setRole(existingRole);
                // rolePermissionRepository.saveAndFlush(mapRolePermission);
                RolePermission rp  = rolePermissionRepository.findByRoleAndPermission(existingRole,exPermission) ==null ?  rolePermissionRepository.save(mapRolePermission):null;
            
            //    System.out.println(a);
            
            }
            return true;
        }return false;
    }

}
