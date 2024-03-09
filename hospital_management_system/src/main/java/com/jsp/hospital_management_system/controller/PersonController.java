package com.jsp.hospital_management_system.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.hospital_management_system.dto.Medorder;
import com.jsp.hospital_management_system.dto.Person;
import com.jsp.hospital_management_system.service.Personservice;
import com.jsp.hospital_management_system.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController

public class PersonController {
	
	@Autowired
	private Personservice personservice;
	
	@ApiOperation(value = "save person",notes = "Api is used to save the person")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully saved")})
	@PostMapping("/saveperson")
	public ResponseEntity<ResponseStructure<Person>> savePerson(@Valid @RequestBody Person person) {
		return personservice.savePerson(person);
	}
	@ApiOperation(value = "update person",notes = "Api is used to update the person")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully updated"),@ApiResponse(code=404,message = "id nor found")})
	@PutMapping("/updateperson")
	public ResponseEntity<ResponseStructure<Person>> updatePerson(@Valid @RequestParam int id,@RequestBody Person person) {
		return personservice.updatePerson(id, person);
	}


	@ApiOperation(value = "Delete person",notes = "Api is used to delete the person")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully deleted"),@ApiResponse(code=404,message = "id nor found")})
	@DeleteMapping("/deleteperson")
	public ResponseEntity<ResponseStructure<Person>> deletePerson(@Valid @RequestParam int id) {
		return personservice.deletePerson(id);
	}
	
	@ApiOperation(value = "Get person by id",notes = "Api is used to get the person")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "successfully found"),@ApiResponse(code=404,message = "id nor found")})
	@GetMapping("/getperson")
	public ResponseEntity<ResponseStructure<Person>> getPerson(@Valid @RequestParam int id) {
		return personservice.getPersonbyid(id);
	}
}
