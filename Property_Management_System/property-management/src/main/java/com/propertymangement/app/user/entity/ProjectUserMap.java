package com.propertymangement.app.user.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.propertymangement.app.project.entity.Project;

import lombok.Data;

@Entity
@Table(name="project_user")
@Data
public class ProjectUserMap {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="id")
private Integer id;

@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "user_pk")
private User user;

@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "project_pk")
private Project project;
}
