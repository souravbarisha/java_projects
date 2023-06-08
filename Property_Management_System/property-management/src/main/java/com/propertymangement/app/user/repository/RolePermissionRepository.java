package com.propertymangement.app.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.propertymangement.app.user.entity.Permission;
import com.propertymangement.app.user.entity.Role;
import com.propertymangement.app.user.entity.RolePermission;

public interface RolePermissionRepository extends JpaRepository<RolePermission, Integer>{

    RolePermission findByRoleAndPermission(Role existingRole, Permission exPermission);
    
}
