package com.propertymangement.app.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.propertymangement.app.user.entity.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Integer>{

    Permission findBypermissionName(String permissionName);

}
