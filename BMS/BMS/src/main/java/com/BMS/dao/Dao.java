package com.BMS.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BMS.entity.Customer;

public interface Dao extends JpaRepository<Customer, Long> {

//	// JPQL
	// @Query("select c from Customer c")
	List<Customer> findByBranch(String branch);
}
