package com.propertymangement.app.project.contoller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.propertymangement.app.project.dto.ProjectDto;
import com.propertymangement.app.project.service.ProjectService;

@RestController
@RequestMapping("/project/v1")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@PostMapping("/add-project")
	public String addProject(@RequestBody ProjectDto projectDto) {
		return projectService.addProject(projectDto);
	}

	@GetMapping("/get-all-project")
	public List<ProjectDto> getAllProjects(){
		if(projectService.getAllProjects().isEmpty()) {
			return new ArrayList<>(0);
		}
		return projectService.getAllProjects();
	}
	// get project by name and location
	@GetMapping("/get-a-project")
	public ProjectDto getProjectByNameAndLocation(@RequestParam String projectName, @RequestParam String location) {
		return projectService.getProjectByNameAndLocation(projectName,location);
	}
//	@GetMapping("/get-a-project")
//	public List<ProjectDto> getProjectByName(@RequestParam String projectName) {
//		return projectService.getProjectByName(projectName);
//	}
}
