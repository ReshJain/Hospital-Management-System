package com.jsp.hospital_management_system.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.Data;

@Entity
@Data
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	private String state;
	@Min(value = 6000000000l,message = "number start from 6 to 9")
	@Max(value = 9999999999l,message = "number start from 6 to 9")
	private long phone;
	@NotBlank(message = "manager name should not be blank")
	private String manager;
	
	
}
