package com.jsp.hospital_management_system.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Data
public class Encounter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Reason should be there")
	private String reason;
	private double cost;
	
	@ManyToOne
	private Person person;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Branch> branchs;
}
