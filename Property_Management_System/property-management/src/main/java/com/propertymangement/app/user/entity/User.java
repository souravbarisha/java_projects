package com.propertymangement.app.user.entity;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ValueGenerationType;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
@Id
@Column(name = "id")
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;

@Column(name = "first_name")
private String firstName;

@Column(name = "last_name")
private String lastName;

@Column(name = "email")
private String emailId;

@Column(name = "mob_no")
private String mobNo;

@Column(name = "password")
private String password;

@Column(name = "role_name")
private String roleName;

@Column(name = "status")
private String status;

@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name="role_id")
private Role role;
 
}
