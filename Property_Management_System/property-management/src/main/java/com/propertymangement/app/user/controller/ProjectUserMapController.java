package com.propertymangement.app.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.propertymangement.app.project.dto.ProjectDto;
import com.propertymangement.app.project.entity.Project;
import com.propertymangement.app.user.dto.ProjectUserMapRequestDto;
import com.propertymangement.app.user.service.ProjectUserMapService;

@RestController
@RequestMapping(value = "/project-user-map")
public class ProjectUserMapController {

	@Autowired
	private ProjectUserMapService projectUserMapService;
	
	@PostMapping(path = "/map")
	public String mapProjectUser(@RequestBody ProjectUserMapRequestDto projectUserMapRequestDto) {
		
			if (!projectUserMapRequestDto.getUserEmail().equals(null) && !projectUserMapRequestDto.getProjects().isEmpty()) {
				return projectUserMapService.mapProjectUser(projectUserMapRequestDto);
			}
			
				return "insuficient data";
			
	}
	           // get projects-by-user-emailid
	@GetMapping(path = "/get-projects-by-user-emailid")
	public List<ProjectDto> getProjectsByUserEmailId(@RequestParam String emailId){
		return projectUserMapService.getProjectsByUserEmailId(emailId);
	}
}
