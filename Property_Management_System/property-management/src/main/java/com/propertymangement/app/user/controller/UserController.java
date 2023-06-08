package com.propertymangement.app.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.propertymangement.app.user.dto.UserDto;
import com.propertymangement.app.user.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
@Autowired
private UserService  userService;

// To create user details
@PostMapping(path="/add-user")
public String createUser(@RequestBody UserDto userDto) {
	return userService.createUser(userDto);
}
// To get all users details
@GetMapping(path= "/get-users")
public List<UserDto> getAllUsers() {
	return userService.getAllUsers();
}
//To get a single user's details by email
@GetMapping(path = "/get-user-by-email/{emailId}")
public UserDto getUserByEmail(@PathVariable String emailId) {
	return userService.getUserByEmail(emailId);
}
// To update the user details
@PutMapping(path = "/update-user")
public UserDto updateUserDetails(@RequestBody UserDto userDto) {
	return userService.updateUserDetails(userDto);
}
// To delete the user details 
@PostMapping(path = "/delete-user")
public String deleteUserDetails(@RequestParam String emailId) {
	return userService.deleteUserDetails(emailId);
}
// To get only all the USER's Details
@GetMapping(path = "/get-only-userslist")
public List<UserDto> getOnlyUsersList(@RequestParam String roleName){
	return userService.getOnlyUsersList(roleName);
}
}
