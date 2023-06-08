package com.propertymangement.app.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.propertymangement.app.project.entity.Project;
import com.propertymangement.app.user.entity.ProjectUserMap;
import com.propertymangement.app.user.entity.User;

public interface ProjectUserMapRepository extends JpaRepository<ProjectUserMap, Integer> {

	ProjectUserMap findByProjectAndUser(Project existingProject, User existingUser);
	
	List<ProjectUserMap> findByUser(User user);
	
}
