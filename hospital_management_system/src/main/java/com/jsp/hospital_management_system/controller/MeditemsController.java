package com.jsp.hospital_management_system.controller;

import javax.swing.plaf.multi.MultiInternalFrameUI;
import javax.validation.Valid;

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
import com.jsp.hospital_management_system.dto.Meditems;
import com.jsp.hospital_management_system.service.Meditemservice;
import com.jsp.hospital_management_system.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController

public class MeditemsController {

	private Meditemservice meditemservice;
	
	@ApiOperation(value = "save meditems",notes = "Api is used to save the meditems")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully saved")})
	@PostMapping("/savemeditems")
	public ResponseEntity<ResponseStructure<Meditems>> saveMeditems(@Valid @RequestBody Meditems meditems,@RequestParam int mid){
		return meditemservice.saveMeditems(meditems, mid);
	}
	@ApiOperation(value = "update meditems",notes = "Api is used to update the meditems")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully updated"),@ApiResponse(code=404,message = "id nor found")})
	@PutMapping("/updatemeditems")
	public  ResponseEntity<ResponseStructure<Meditems>> updateMeditems(@Valid @RequestBody Meditems meditems,@RequestParam int id) {
		return meditemservice.updteMeditems(id, meditems);
	}
	
	@ApiOperation(value = "Delete meditems",notes = "Api is used to delete the meditems")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully deleted"),@ApiResponse(code=404,message = "id nor found")})
	@DeleteMapping("/deletemeditems")
	public  ResponseEntity<ResponseStructure<Meditems>> deleteMeditems(@Valid @RequestParam int id) {
		return meditemservice.deleteMeditems(id);
	}
	
	@ApiOperation(value = "Get meditems by id",notes = "Api is used to get the meditems")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "successfully found"),@ApiResponse(code=404,message = "id nor found")})
	@GetMapping("/getmeditemsbyid")
	public  ResponseEntity<ResponseStructure<Meditems>> getMeditems(@Valid @RequestParam int id) {
		return meditemservice.getMeditemsbyid(id);
	}
}
