package com.propertymangement.app.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.propertymangement.app.user.dto.UserDto;
import com.propertymangement.app.user.entity.Role;
import com.propertymangement.app.user.entity.User;
import com.propertymangement.app.user.repository.RoleRepository;
import com.propertymangement.app.user.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
   
	String normal= "ACTIVE";
	String cancle= "INACTIVE";
	
	// To create user details
	public String createUser(UserDto userDto) {
		User existingUser = userRepository.findByEmailId(userDto.getEmailId()); // find emailId
		//User findByEmaildAndStatus(String emailId, String status);
		Role existingRole = roleRepository.findByRoleName(userDto.getRoleName());
		if(existingUser != null) {
			if( existingUser.getStatus().equals(cancle)) {
				if(existingRole !=null) {
					User newUser = new User(); // creating an object of User class
					//setting data of entity class through Dto class 
					newUser.setId(existingUser.getId());
					newUser.setFirstName(existingUser.getFirstName());
					newUser.setLastName(existingUser.getLastName());
					newUser.setEmailId(existingUser.getEmailId());
					newUser.setMobNo(existingUser.getMobNo());
					newUser.setPassword(existingUser.getPassword());
					newUser.setRoleName(existingUser.getRoleName());
					newUser.setRole(existingUser.getRole());
					newUser.setStatus(normal);
					userRepository.save(newUser); // save in repository
					
					return "User is ACTIVETED";
				}
				return "Please enter the correct role";
			}
			return "User is Already Exist";
		}
			
		
		    // else part
			if(existingRole !=null) {
				User newUser = new User(); // creating an object of User class
				//setting data of entity class through Dto class 
				newUser.setFirstName(userDto.getFirstName());
				newUser.setLastName(userDto.getLastName());
				newUser.setEmailId(userDto.getEmailId());
				newUser.setMobNo(userDto.getMobNo());
				newUser.setPassword(userDto.getPassword());
				newUser.setRoleName(existingRole.getRoleName());
				newUser.setRole(existingRole);
				newUser.setStatus(normal);
				userRepository.save(newUser); // save in repository
				return "Save successfully";
			}
			return "Please enter the correct Role";
		}
	
	// To get all users details
	public List<UserDto> getAllUsers(){
		List<User> users = new ArrayList<>(); // creating ArrayList object of entity class
		users= userRepository.findAll();  // find all data of entity class
		List<UserDto> usersDto = new ArrayList<>(); // creating ArrayList object of dto class
		for(int i=0; i<users.size(); i++) {   // using for loop, transfer all data into dto class from entity class
			User newUser = users.get(i);
			UserDto newUserDto = new UserDto();
			// setting values of newUserDto from newUser
			newUserDto.setFirstName(newUser.getFirstName());
			newUserDto.setLastName(newUser.getLastName());
			newUserDto.setEmailId(newUser.getEmailId());
			newUserDto.setMobNo(newUser.getMobNo());
			newUserDto.setPassword(newUser.getPassword());
			newUserDto.setRoleName(newUser.getRoleName());
			newUserDto.setRoleId(newUser.getRole().getId());
			newUserDto.setStatus(newUser.getStatus());
			// adding all data(newUserDto) into usersDto list
			usersDto.add(newUserDto);
		}
		return usersDto;
	}
	// To get a single user details by email
	public UserDto getUserByEmail(String emailId) {
		User existingUser = userRepository.findByEmailId(emailId); // find emailId
		if(existingUser != null) {// if email id is exists in the database then condition applied
			  // creating an object of UserDto
			UserDto userDto = new UserDto();
			// fetching data from Entity to Dto
			userDto.setFirstName(existingUser.getFirstName());
			userDto.setLastName(existingUser.getLastName());
			userDto.setEmailId(existingUser.getEmailId());
			userDto.setMobNo(existingUser.getMobNo());
			userDto.setPassword(existingUser.getPassword());
			userDto.setRoleId(existingUser.getRole().getId());
			userDto.setRoleName(existingUser.getRoleName());
			userDto.setStatus(existingUser.getStatus());
			
			return userDto; // return the object of UserDto
		}
		return null; // if email id is not exists in the database then condition applied
	}
	// To update the user details 
	public UserDto updateUserDetails(UserDto userDto) {
		User existingUser = userRepository.findByEmailId(userDto.getEmailId()); //find emailId
		if(existingUser != null) {//if email id is exists in the database then condition applied
			
			User updatedUser = new User();
			// updating and setting all the data of User class 
			updatedUser.setFirstName(userDto.getFirstName());
			updatedUser.setLastName(userDto.getLastName());
			updatedUser.setMobNo(userDto.getMobNo());
			updatedUser.setPassword(userDto.getPassword());
			// not want to update
			updatedUser.setEmailId(existingUser.getEmailId());
			updatedUser.setId(existingUser.getId());
			updatedUser.setRole(existingUser.getRole());
			updatedUser.setRoleName(existingUser.getRoleName());
			updatedUser.setStatus(existingUser.getStatus());
			//saving at repository
			userRepository.save(updatedUser);
			// creating an object of UserDto class
			UserDto updatedUserDto = new UserDto();
			// set into dto class the updating object as updatedUserDto
			updatedUserDto.setFirstName(updatedUser.getFirstName());
			updatedUserDto.setLastName(updatedUser.getLastName());
			updatedUserDto.setMobNo(updatedUser.getMobNo());
			updatedUserDto.setRoleId(updatedUser.getRole().getId());
			updatedUserDto.setRoleName(updatedUser.getRoleName());
			updatedUserDto.setPassword(updatedUser.getPassword());
			updatedUserDto.setEmailId(updatedUser.getEmailId());
			updatedUserDto.setStatus(updatedUser.getStatus());
			
			return  updatedUserDto;
		}
		return null;
	}
//	To delete the user details
	public String deleteUserDetails(String emailId) {
		User existingUser = userRepository.findByEmailId(emailId); // find emailId
		if(existingUser == null) {// condition of availability of the emailId
			return "This email Id is not available";
		}
		else {
			   User user = new User(); // creating an object of User class
			
			   // setting all the data of the user
			   user.setStatus(cancle); // set the status of the user
			   user.setEmailId(existingUser.getEmailId());
			   user.setFirstName(existingUser.getFirstName());
			   user.setLastName(existingUser.getLastName());
			   user.setMobNo(existingUser.getMobNo());
			   user.setPassword(existingUser.getPassword());
			   user.setRoleName(existingUser.getRoleName());
			   user.setRole(existingUser.getRole());
			   user.setId(existingUser.getId());
			userRepository.save(user);
			
			return "The user "+ emailId +" has been INACTIVETED";
		}
		
	}
	// To get only all the USER's Details
	public List<UserDto> getOnlyUsersList(String roleName) {
	   //checking the role name is exist or not by using findByRoleName
		Role existingRole = roleRepository.findByRoleName(roleName);
		// searching the users by existingRole and store in existingUsers
		List<User> existingUsers = userRepository.findByRole(existingRole);
		if(!existingUsers.isEmpty()) {// condition of it is empty or not
			List<UserDto> usersDto = new ArrayList<>();//creating a list object to store searching role's user
		for(int i=0; i<existingUsers.size(); i++) {
				User user = existingUsers.get(i);
				
				UserDto newUserDto = new UserDto();
				// fetching data
				newUserDto.setEmailId(user.getEmailId());
				newUserDto.setFirstName(user.getFirstName());
				newUserDto.setLastName(user.getLastName());
				newUserDto.setEmailId(user.getEmailId());
				newUserDto.setMobNo(user.getMobNo());
				newUserDto.setPassword(user.getPassword());
				newUserDto.setRoleName(user.getRoleName());
				newUserDto.setStatus(user.getStatus());
				newUserDto.setRoleId(user.getRole().getId());
				
				// adding all data(newUserDto) into usersDto list
				usersDto.add(newUserDto);
			}
		return usersDto;
		}
		return new ArrayList<>(0);
	}
}
