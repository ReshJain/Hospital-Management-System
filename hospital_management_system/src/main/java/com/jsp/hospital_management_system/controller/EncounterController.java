package com.jsp.hospital_management_system.controller;

import javax.management.relation.InvalidRelationTypeException;
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

import com.jsp.hospital_management_system.dto.Encounter;
import com.jsp.hospital_management_system.service.Encounterservice;
import com.jsp.hospital_management_system.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class EncounterController {

	@Autowired
	private Encounterservice encounterservice;
	
	@ApiOperation(value = "save encounter",notes = "Api is used to save the encounter")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully saved")})
	@PostMapping("/saveencounter")
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(@Valid @RequestBody Encounter encounter,@RequestParam int pid,@RequestParam int bid) {
		return encounterservice.saveEncounter(encounter, pid, bid);
	}
	
	@ApiOperation(value = "update encounter",notes = "Api is used to update the encounter")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully updated"),@ApiResponse(code=404,message = "id nor found")})
	@PutMapping("/updateencounter")
	public  ResponseEntity<ResponseStructure<Encounter>>  updatEncounter(@Valid @RequestParam int id,@RequestBody Encounter encounter,@RequestParam int bid) {
		return encounterservice.updateEncounter(id, encounter, bid);
	}
	
	@ApiOperation(value = "Delete encounter",notes = "Api is used to delete the encounter")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully deleted"),@ApiResponse(code=404,message = "id nor found")})
	@DeleteMapping("/deleteencounter")
	public ResponseEntity<ResponseStructure<Encounter>>  deletEncounter(@Valid @RequestParam int id) {
		return encounterservice.deletEncounter(id);
	}
	
	@ApiOperation(value = "Get encounter by id",notes = "Api is used to get the encounter")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "successfully found"),@ApiResponse(code=404,message = "id nor found")})
	@GetMapping("/getencounterbyid")
	public  ResponseEntity<ResponseStructure<Encounter>>  getEncounter(@Valid @RequestParam int id) {
		return encounterservice.getEncounterbyid(id);
	}
}
