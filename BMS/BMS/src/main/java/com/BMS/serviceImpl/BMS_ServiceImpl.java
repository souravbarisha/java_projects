package com.BMS.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BMS.dao.Dao;
import com.BMS.dto.UserRequestDTO;
import com.BMS.entity.Customer;
import com.BMS.service.BMS_Service;

@Service
public class BMS_ServiceImpl implements BMS_Service {
	@Autowired
	private Dao dao;

//	public Customer saveUser(UserRequestDTO userRequest) {
//		User user = User.builder().name(userRequest.getName()).email(userRequest.getEmail())
//				.mobile(userRequest.getMobile()).age(userRequest.getAge()).build();
//		return userRepository.save(user);
//	}

//create customers details
//	@Override
//	public Customer createCustomer(Customer customer) {
//		return dao.save(customer);
//	}
//	public Employee saveEmployee(UserRequestDTO userRequest) {
//		Employee employee = Employee.builder().name(userRequest.getName()).email(userRequest.getEmail())
//				.department(userRequest.getDepartment()).build();
//		return employeeRepositary.save(employee);
//	}
	@Override
	public Customer createCustomer(UserRequestDTO userRequest) {
		// TODO Auto-generated method stub
		Customer customer = Customer.builder().acc_no(userRequest.getAcc_no()).acc_holder(userRequest.getAcc_holder())
				.phone_no(userRequest.getPhone_no()).pin(userRequest.getPin()).ifsc(userRequest.getIfsc())
				.branch(userRequest.getBranch()).acc_type(userRequest.getAcc_type()).acc_bal(userRequest.getAcc_bal())
				.build();
		return dao.save(customer);
	}

//get all customers details
	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

//get a single customer details
	@Override
	public Customer getACustomer(long ac) {
		// TODO Auto-generated method stub
		return dao.findById(ac).get();
	}

//update a customer details
	@Override
	public Customer updateCustomer(Customer acc) {
		// TODO Auto-generated method stub
		return dao.save(acc);
	}

//delete customer details
	@Override
	public String deleteCustomer(long ac) {
		// TODO Auto-generated method stub
		dao.deleteById(ac);
		return "The customer with AC NO. " + ac + " has been deleted";
	}

	@Override
	public List<Customer> getAllCustomersByJPQL(String branch) {
		// TODO Auto-generated method stub
		return dao.findByBranch(branch);
	}

}
