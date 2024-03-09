package com.jsp.hospital_management_system.controller;

import java.security.PublicKey;

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

import com.jsp.hospital_management_system.dto.Meditems;
import com.jsp.hospital_management_system.dto.Medorder;
import com.jsp.hospital_management_system.service.Medorderservice;
import com.jsp.hospital_management_system.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MedorderController {

	@Autowired
	private Medorderservice medorderservice;
	
	@ApiOperation(value = "save medorder",notes = "Api is used to save the medorder")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully saved")})
	@PostMapping("/savemedorder")
	public ResponseEntity<ResponseStructure<Medorder>> saveMedorder(@Valid @RequestBody Medorder medorder,@RequestParam int eid) {
		return medorderservice.saveMedorder(medorder, eid);
	}
	
	@ApiOperation(value = "update medorder",notes = "Api is used to update the medorder")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully updated"),@ApiResponse(code=404,message = "id nor found")})
	@PutMapping("/updatemedorder")
	public ResponseEntity<ResponseStructure<Medorder>>  updateMedorder(@Valid @RequestParam int id,@RequestBody Medorder medorder) {
		return medorderservice.updateMedorder(id, medorder);
		
	}
	@ApiOperation(value = "Delete medorder",notes = "Api is used to delete the medorder")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully deleted"),@ApiResponse(code=404,message = "id nor found")})
	@DeleteMapping("/deletemedorder")
	public ResponseEntity<ResponseStructure<Medorder>>  deleteMedorder(@Valid @RequestParam int id) {
		return medorderservice.deleteMedorder(id);
	}
	
	@ApiOperation(value = "Get medorder by id",notes = "Api is used to get the medorder")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "successfully found"),@ApiResponse(code=404,message = "id nor found")})
	@GetMapping("getmedorderbyid")
	public ResponseEntity<ResponseStructure<Medorder>>  getMedorder(@Valid @RequestParam int id) {
		return medorderservice.getMedorderbyid(id);
	}
}
