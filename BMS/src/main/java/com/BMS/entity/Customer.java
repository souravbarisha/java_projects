package com.BMS.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bank_Customer_Details")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Customer {
	@Id
	private long acc_no;
	@Column(length = 20, nullable = false, unique = true)
	private String acc_holder;
	@Column(length = 20, nullable = false)
	private String ifsc;
	@Column(length = 11, nullable = false)
	private String branch;
	@Column(length = 20, nullable = false)
	private String acc_type;
	@Column(length = 20, nullable = false)
	private double acc_bal;
	@Column(length = 20, nullable = false)
	private long phone_no;
	@Column(length = 10, nullable = false)
	private int pin;
}
