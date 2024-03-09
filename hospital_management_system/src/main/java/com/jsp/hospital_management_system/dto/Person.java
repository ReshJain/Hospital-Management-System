package com.jsp.hospital_management_system.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "name should not be blank")
	private String name;
	@Pattern(regexp ="^[A-Za-z0-9+_.-]+@(.+)$")
	private String email;
	@Min(value = 6000000000l)
	@Max(value = 9999999999l)
	@Pattern(regexp="(^$ [0-9]{10})")
	private String phone;
}
