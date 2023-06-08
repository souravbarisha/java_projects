package com.propertymangement.app.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.propertymangement.app.user.entity.Role;
import com.propertymangement.app.user.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // find by email id
	User findByEmailId(String emailId);
	User findByEmailIdAndPassword(String emailId, String password);
//	User findByEmaiIdAndStatus(String emailId, String status);
	List<User> findByRole(Role role);
}
