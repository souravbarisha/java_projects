package com.propertymangement.app.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.propertymangement.app.user.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByRoleName(String roleName);
}
