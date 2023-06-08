package com.propertymangement.app.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.propertymangement.app.project.dto.ProjectDto;
import com.propertymangement.app.project.entity.Project;
import com.propertymangement.app.project.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	public String addProject(ProjectDto projectDto) {
		
		Project existingProject = projectRepository.findByProjectNameAndLocation(projectDto.getProjectName(),projectDto.getLocation());
		if(existingProject==null) {
		Project newProject = new Project();
		newProject.setProjectName(projectDto.getProjectName());
		newProject.setBhkConfiguration(projectDto.getBhkConfiguration());
		newProject.setCommunityHall(projectDto.getCommunityHall());
		newProject.setCoverImageUrl(projectDto.getCoverImageUrl());
		newProject.setCreachToddlerZone(projectDto.getCreachToddlerZone());
		newProject.setIndoorGamesRoom(projectDto.getIndoorGamesRoom());
		newProject.setJoggingTrack(projectDto.getJoggingTrack());
		newProject.setLocation(projectDto.getLocation());
		newProject.setNoOfTowers(projectDto.getNoOfTowers());
		newProject.setPartyLawn(projectDto.getPartyLawn());
		newProject.setPlayground(projectDto.getPlayground());
		newProject.setPricingStratingFrom(projectDto.getPricingStratingFrom());
		newProject.setProjectArea(projectDto.getProjectArea());
		newProject.setProjectStartDate(projectDto.getProjectStartDate());
		newProject.setProjectEndDate(projectDto.getProjectEndDate());
		newProject.setProjectOverview(projectDto.getProjectOverview());
		newProject.setSizeStartSqft(projectDto.getSizeStartSqft());
		newProject.setSizeUptoSqft(projectDto.getSizeUptoSqft());
		newProject.setStatus(projectDto.getStatus());
		newProject.setSwimmingPool(projectDto.getSwimmingPool());
		newProject.setYogaDeck(projectDto.getYogaDeck());
		projectRepository.save(newProject);
		return "Project is  successfully added!";
			}
		return "The Project is already exist....";
	}
	
	public List<ProjectDto> getAllProjects(){
		List<Project> projects = projectRepository.findAll();
		List<ProjectDto> projectDtos = new ArrayList<>();
		for(int i =0; i<projects.size();i++) {
			Project project = projects.get(i);
			ProjectDto dto = new ProjectDto();
			dto.setBhkConfiguration(project.getBhkConfiguration());
			dto.setCommunityHall(project.getCommunityHall());
			dto.setCoverImageUrl(project.getCoverImageUrl());
			dto.setCreachToddlerZone(project.getCreachToddlerZone());
			dto.setIndoorGamesRoom(project.getIndoorGamesRoom());
			dto.setJoggingTrack(project.getJoggingTrack());
			dto.setLocation(project.getLocation());
			dto.setNoOfTowers(project.getNoOfTowers());
			dto.setPartyLawn(project.getPartyLawn());
			dto.setPlayground(project.getPlayground());
			dto.setPricingStratingFrom(project.getPricingStratingFrom());
			dto.setProjectArea(project.getProjectArea());
			dto.setProjectStartDate(project.getProjectStartDate());
			dto.setProjectEndDate(project.getProjectEndDate());
			dto.setProjectOverview(project.getProjectOverview());
			dto.setSizeStartSqft(project.getSizeStartSqft());
			dto.setSizeUptoSqft(project.getSizeUptoSqft());
			dto.setStatus(project.getStatus());
			dto.setSwimmingPool(project.getSwimmingPool());
			dto.setYogaDeck(project.getYogaDeck());
			dto.setProjectName(project.getProjectName());
			projectDtos.add(dto);
		}
		return projectDtos;
	}
	   // get project by name and location
	public ProjectDto getProjectByNameAndLocation(String projectName, String location) {
		     // creating an object of project
		Project existingProject = projectRepository.findByProjectNameAndLocation(projectName,location);// find by projectName
        if(existingProject == null) {// checking condition, if not exist then return null value
        	return null;
        }
        // else part / if exist then return the project
        ProjectDto projectDto = new ProjectDto(); // creating an object of ProjectDto class
        //fetching data from entity to dto class
        projectDto.setProjectName(existingProject.getProjectName());
        projectDto.setBhkConfiguration(existingProject.getBhkConfiguration());
        projectDto.setCommunityHall(existingProject.getCommunityHall());
        projectDto.setCoverImageUrl(existingProject.getCoverImageUrl());
        projectDto.setCreachToddlerZone(existingProject.getCreachToddlerZone());
        projectDto.setIndoorGamesRoom(existingProject.getIndoorGamesRoom());
        projectDto.setJoggingTrack(existingProject.getJoggingTrack());
        projectDto.setLocation(existingProject.getLocation());
        projectDto.setNoOfTowers(existingProject.getNoOfTowers());
        projectDto.setPartyLawn(existingProject.getPartyLawn());
        projectDto.setPlayground(existingProject.getPlayground());
        projectDto.setPricingStratingFrom(existingProject.getPricingStratingFrom());
        projectDto.setProjectArea(existingProject.getProjectArea());
        projectDto.setProjectOverview(existingProject.getProjectOverview());
        projectDto.setProjectStartDate(existingProject.getProjectStartDate());
        projectDto.setProjectEndDate(existingProject.getProjectEndDate());
        projectDto.setSizeStartSqft(existingProject.getSizeStartSqft());
        projectDto.setSizeUptoSqft(existingProject.getSizeUptoSqft());
        projectDto.setSwimmingPool(existingProject.getSwimmingPool());
        projectDto.setYogaDeck(existingProject.getYogaDeck());
        projectDto.setStatus(existingProject.getStatus());
        
		return projectDto;  // return the project
	}
}
