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

import com.jsp.hospital_management_system.dto.Address;
import com.jsp.hospital_management_system.dto.Hospital;
import com.jsp.hospital_management_system.service.Addressservice;
import com.jsp.hospital_management_system.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController

public class AddressController {

	@Autowired
	private Addressservice addressservice;
	private Addressservice addresservice;
	
	@ApiOperation(value = "save address",notes = "Api is used to save the address")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully saved")})
	@PostMapping("/saveaddress")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@Valid @RequestBody Address address) {
		return addresservice.saveAddress(address);
		
	}
	@ApiOperation(value = "update address",notes = "Api is used to update the address")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully updated"),@ApiResponse(code=404,message = "id nor found")})
	@PutMapping("/updateaddress")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@Valid @RequestParam int id,@RequestBody Address address) {
		return addressservice.updateAddress(id, address);
		
	}
	@ApiOperation(value = "Delete address",notes = "Api is used to delete the address")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully deleted"),@ApiResponse(code=404,message = "id nor found")})
	@DeleteMapping("/deleteaddress")
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(@Valid @RequestParam int id) {
		return addressservice.deleteAddress(id);
		
	}
	
	@ApiOperation(value = "Get address by id",notes = "Api is used to get the address")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "successfully found"),@ApiResponse(code=404,message = "id nor found")})
	@GetMapping("/getaddressbyid")
	public ResponseEntity<ResponseStructure<Address>> getAddressbyid(@RequestParam int id) {
		return addressservice.getAddressbyid(id);
	}
}





