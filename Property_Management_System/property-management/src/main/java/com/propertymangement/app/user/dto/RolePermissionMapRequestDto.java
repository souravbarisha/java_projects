package com.propertymangement.app.user.dto;

import java.util.List;

import com.propertymangement.app.user.entity.Permission;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RolePermissionMapRequestDto {

    private Integer roleId;
    private List<Permission> permissions; 
    
}
