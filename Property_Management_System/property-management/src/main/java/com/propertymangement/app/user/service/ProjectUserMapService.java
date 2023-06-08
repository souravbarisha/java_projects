package com.propertymangement.app.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.propertymangement.app.project.dto.ProjectDto;
import com.propertymangement.app.project.entity.Project;
import com.propertymangement.app.project.repository.ProjectRepository;
import com.propertymangement.app.user.dto.ProjectUserMapRequestDto;
import com.propertymangement.app.user.dto.UserDto;
import com.propertymangement.app.user.entity.ProjectUserMap;
import com.propertymangement.app.user.entity.User;
import com.propertymangement.app.user.repository.ProjectUserMapRepository;
import com.propertymangement.app.user.repository.UserRepository;

@Service
public class ProjectUserMapService {

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProjectUserMapRepository projectUserMapRepository;

	public String mapProjectUser(ProjectUserMapRequestDto projectUserMapRequestDto) {

		User existingUser = userRepository.findByEmailId(projectUserMapRequestDto.getUserEmail());
		int counter = 0;
		int notExistingProject = 0;
		List<String> notExistingProjectName = new ArrayList<>(); 
		if (existingUser.getRoleName().equals("ADMIN")) {
			for (Project project : projectUserMapRequestDto.getProjects()) {
				Project existingProject = projectRepository.findByProjectNameAndLocation(project.getProjectName(),
						project.getLocation());

				if (existingProject != null) {
					ProjectUserMap existingProjectUserMap = projectUserMapRepository
							.findByProjectAndUser(existingProject, existingUser);
					if (existingProjectUserMap == null) {
						ProjectUserMap projectUserMap = new ProjectUserMap();
						projectUserMap.setProject(existingProject);
						projectUserMap.setUser(existingUser);
						projectUserMapRepository.save(projectUserMap);

						continue;

					} else {
						counter++;
					}
					continue;
				} 
                else {
                	notExistingProject ++;
                	notExistingProjectName.add(project.getProjectName());
				}
			}
			if (counter > 0) {
				return "mapping successfull but there some existing mapping";
			} 
			
			else if(notExistingProject > 0) {
				String noneExistingProjectName = String.join(", ",notExistingProjectName );
				return "Mapping is successful, but "+ noneExistingProjectName+" are not existed";
			}else {
				return "All Mapping are successfully Done";
			}

		} else {
			return "User is not ADMIN";
		}

	}
	// get projects by user emailid
	public List<ProjectDto> getProjectsByUserEmailId(String emailId) {
		
		User existingUser = userRepository.findByEmailId(emailId);
		
		List<ProjectDto> dto = new ArrayList<>(); 
		
		if(existingUser != null) {
			List<ProjectUserMap> existingProjects = projectUserMapRepository.findByUser(existingUser);
			for(ProjectUserMap projectUserMap : existingProjects) {
				ProjectDto projectDto = new ProjectDto();
				
				projectDto.setProjectName(projectUserMap.getProject().getProjectName());
				projectDto.setBhkConfiguration(projectUserMap.getProject().getBhkConfiguration());
				projectDto.setCommunityHall(projectUserMap.getProject().getCommunityHall());
				projectDto.setCoverImageUrl(projectUserMap.getProject().getCoverImageUrl());
				projectDto.setCreachToddlerZone(projectUserMap.getProject().getCreachToddlerZone());
				projectDto.setIndoorGamesRoom(projectUserMap.getProject().getIndoorGamesRoom());
				projectDto.setJoggingTrack(projectUserMap.getProject().getJoggingTrack());
				projectDto.setLocation(projectUserMap.getProject().getLocation());
				projectDto.setNoOfTowers(projectUserMap.getProject().getNoOfTowers());
				projectDto.setPartyLawn(projectUserMap.getProject().getPartyLawn());
				projectDto.setPlayground(projectUserMap.getProject().getPlayground());
				projectDto.setPricingStratingFrom(projectUserMap.getProject().getPricingStratingFrom());
				projectDto.setProjectArea(projectUserMap.getProject().getProjectArea());
				projectDto.setProjectOverview(projectUserMap.getProject().getProjectOverview());
				projectDto.setProjectStartDate(projectUserMap.getProject().getProjectStartDate());
				projectDto.setProjectEndDate(projectUserMap.getProject().getProjectEndDate());
				projectDto.setSizeStartSqft(projectUserMap.getProject().getSizeStartSqft());
				projectDto.setSizeUptoSqft(projectUserMap.getProject().getSizeUptoSqft());
				projectDto.setStatus(projectUserMap.getProject().getStatus());
				projectDto.setSwimmingPool(projectUserMap.getProject().getSwimmingPool());
				projectDto.setYogaDeck(projectUserMap.getProject().getYogaDeck());
				
				dto.add(projectDto);
				
			}
			return dto;
			
		}
		
		
		return new ArrayList<>(0);
	}

}
