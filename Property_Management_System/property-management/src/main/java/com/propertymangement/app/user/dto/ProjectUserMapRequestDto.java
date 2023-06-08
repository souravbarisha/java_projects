package com.propertymangement.app.user.dto;

import java.util.List;

import com.propertymangement.app.project.entity.Project;

import lombok.Data;

@Data
public class ProjectUserMapRequestDto {

	List<Project> projects;
	
	private String userEmail;

}
