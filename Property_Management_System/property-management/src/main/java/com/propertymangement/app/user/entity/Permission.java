package com.propertymangement.app.user.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.management.relation.Role;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "permission")
@Data
public class Permission {
@Id
@Column(name = "id")
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;

@Column(name = "permission_name")
private String permissionName;


}
