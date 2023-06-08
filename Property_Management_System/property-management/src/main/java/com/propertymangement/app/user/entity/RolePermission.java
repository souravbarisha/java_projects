package com.propertymangement.app.user.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="role_permission")
@Getter
@Setter
public class RolePermission {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="role_pk")
	private Role role;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="permission_pk")
	private Permission permission;
	
	
}
