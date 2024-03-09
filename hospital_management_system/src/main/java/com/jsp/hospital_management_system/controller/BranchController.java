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
import com.jsp.hospital_management_system.dto.Branch;
import com.jsp.hospital_management_system.service.Branchservice;
import com.jsp.hospital_management_system.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.bytebuddy.asm.Advice.Return;

@RestController
public class BranchController {
	@Autowired
	private Branchservice branchservice;
	
	@ApiOperation(value = "save branch",notes = "Api is used to save the branch")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully saved")})
	@PostMapping("/savebranch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@Valid @RequestParam int hid,@RequestParam int aid,@RequestBody Branch branch) {
		return branchservice.saveBranch(hid, aid, branch);
	}
	
	@ApiOperation(value = "update branch",notes = "Api is used to update the branch")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully updated"),@ApiResponse(code=404,message = "id nor found")})
	@PutMapping("/updatebranch")
	public ResponseEntity<ResponseStructure<Branch>> upadateBranch(@Valid @RequestParam int id, @RequestBody Branch branch) {
		return branchservice.updateBranch(id,branch);
	}
	
	@ApiOperation(value = "Delete branch",notes = "Api is used to delete the branch")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully deleted"),@ApiResponse(code=404,message = "id nor found")})
	@DeleteMapping("/deletebranch")
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(@Valid @RequestParam int id) {
		return branchservice.deleteBranch(id);
	}
	@ApiOperation(value = "Get branch by id",notes = "Api is used to get the address")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "successfully found"),@ApiResponse(code=404,message = "id nor found")})
	@GetMapping("/getbranchbyid")
	public ResponseEntity<ResponseStructure<Branch>> getBranch(@Valid @RequestParam int id) {
		return branchservice.getBranchbyid(id);
	}
	

}
