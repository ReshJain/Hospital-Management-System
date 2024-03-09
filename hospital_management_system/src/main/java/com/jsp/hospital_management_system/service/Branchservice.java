package com.jsp.hospital_management_system.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hospital_management_system.dao.Branchdao;
import com.jsp.hospital_management_system.dto.Address;
import com.jsp.hospital_management_system.dto.Branch;
import com.jsp.hospital_management_system.exception.IdNotFoundException;
import com.jsp.hospital_management_system.util.ResponseStructure;

@Service
public class Branchservice {

	@Autowired
	private Branchdao branchdao;
	
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(int hid,int aid,Branch branch) {
		ResponseStructure<Branch> responseStructure = new ResponseStructure<Branch>();
		responseStructure.setMessage("successfull saved ");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(branchdao.saveBranch(hid, aid, branch));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.CREATED);
		
	}
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(int id,Branch branch) {
		Branch dbBranch=branchdao.updateBranch(id, branch);
		if(dbBranch!=null) {
			ResponseStructure<Branch> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("successfully updated");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dbBranch);
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException("id not found for Branch");
		}
		
	}
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(int id) {
		Branch branch=branchdao.deleteBranch(id);
		if(branch!=null) {
			ResponseStructure<Branch> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("successfully updated");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(branch);
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException("id not found ");
		}
		
	}
	public ResponseEntity<ResponseStructure<Branch>>getBranchbyid(int id) {
		Branch branch=branchdao.getbranchbyid(id);
		if(branch!=null) {
			ResponseStructure<Branch> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Found successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(branch);
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.FOUND);
		}else {
			throw new NoSuchElementException("no id found");
		}
		
	}
}
