package com.BMS.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequestDTO {

	@Digits(integer = 9, fraction = 0, message = "AC NO. should be 9 digits")
	long acc_no;

	@NotBlank(message = "Invalid Name: Empty name")
	@NotNull(message = "Invalid Name: Name is null")
	@Size(min = 2, max = 50, message = "Name should be 2-50 charecters")
	String acc_holder;

	@Digits(integer = 10, fraction = 0, message = "Phone Number should be 10 digits")
	long phone_no;

	@Digits(integer = 6, fraction = 0, message = "Pin should be 6 digits")
	int pin;

	@NotBlank(message = "Invalid ifsc: Empty ifsc")
	@NotNull(message = "Invalid ifsc: ifsc is null")
	@Size(min = 11, max = 11, message = "IFSC should be 11 digits")
	String ifsc;

	@NotBlank(message = "Invalid acc type: Empty acc type")
	@NotNull(message = "Invalid acc type: acc type is null")
	String acc_type;

	@NotBlank(message = "Invalid branch: Empty branch")
	@NotNull(message = "Invalid branch: branch is null")
	String branch;

	double acc_bal;

}
