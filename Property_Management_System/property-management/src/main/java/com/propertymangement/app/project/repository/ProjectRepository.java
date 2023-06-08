package com.propertymangement.app.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.propertymangement.app.project.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer>{

	Project findByProjectName(String projectName);
	Project findByProjectNameAndLocation(String projectName, String location);
	
	
}
