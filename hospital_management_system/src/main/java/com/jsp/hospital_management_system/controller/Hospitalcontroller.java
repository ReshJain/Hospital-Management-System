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

import com.jsp.hospital_management_system.dto.Hospital;
import com.jsp.hospital_management_system.service.Hospitalservice;
import com.jsp.hospital_management_system.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController

public class Hospitalcontroller {

	@Autowired
	private Hospitalservice hospitalservice;
	
	@ApiOperation(value = "save hospital",notes = "Api is used to save the hospital")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully saved")})
	@PostMapping("/savehospital")
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@Valid @RequestBody Hospital hospital) {
		return hospitalservice.saveHospital(hospital);
		
	}
	@ApiOperation(value = "update hospital",notes = "Api is used to update the hospital")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully updated"),@ApiResponse(code=404,message = "id nor found")})
	@PutMapping("/updatehospital")
	public ResponseEntity<ResponseStructure<Hospital>>updateHospital(@Valid @RequestParam int id,@RequestBody Hospital hospital) {
		return hospitalservice.updateHospital(id, hospital);
	}
	
	@ApiOperation(value = "Delete hospital",notes = "Api is used to delete the hospital")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully deleted"),@ApiResponse(code=404,message = "id nor found")})
	@DeleteMapping("/deletehospital")
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(@Valid @RequestParam int id) {
		return hospitalservice.deleteHospital(id);
	}
	@ApiOperation(value = "Get hospital by id",notes = "Api is used to get the hospital")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "successfully found"),@ApiResponse(code=404,message = "id nor found")})
	@GetMapping("/gethospitalbyid")
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalbyid(@Valid @RequestParam int id) {
		return hospitalservice.getHospitalbyid(id);
	}
}
