package com.BMS.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.BMS.dto.UserRequestDTO;
import com.BMS.entity.Customer;

@Component
public interface BMS_Service {
	// create customer details
	// Customer createCustomer(Customer customer);
	Customer createCustomer(UserRequestDTO userRequest);

	// get all customers details
	List<Customer> getAllCustomers();

	// get a single customer details
	Customer getACustomer(long ac);

	// update a customer details
	Customer updateCustomer(Customer acc);

	// delete customer details
	String deleteCustomer(long ac);

	// get all customer by JPQL
	List<Customer> getAllCustomersByJPQL(String branch);
}
