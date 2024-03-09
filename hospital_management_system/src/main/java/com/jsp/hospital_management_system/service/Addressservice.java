package com.jsp.hospital_management_system.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hospital_management_system.dao.Addressdao;
import com.jsp.hospital_management_system.dto.Address;
import com.jsp.hospital_management_system.dto.Hospital;
import com.jsp.hospital_management_system.exception.IdNotFoundException;
import com.jsp.hospital_management_system.util.ResponseStructure;

@Service
public class Addressservice {

	@Autowired
	private Addressdao addressdao;
	
	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {
		ResponseStructure<Address> responseStructure = new ResponseStructure<Address>();
		responseStructure.setMessage("successfull saved ");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(addressdao.saveAddress(address));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.CREATED);
		
	}
	public ResponseEntity<ResponseStructure<Address>> updateAddress(int id,Address address) {
		Address dbAddress=addressdao.updateAddress(id, address);
		if(dbAddress!=null) {
			ResponseStructure<Address> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("successfully updated");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dbAddress);
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
		}else{
			throw new IdNotFoundException("id not found for Address");
			
		}
		
	}
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(int id) {
		Address address=addressdao.deleteAddress(id);
		if(address!=null) {
			ResponseStructure<Address> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("successfully updated");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException("id not found");
		}
		
	}
	public ResponseEntity<ResponseStructure<Address>> getAddressbyid(int id) {
		Address address=addressdao.getaddressbyid(id);
		if(address!=null) {
			ResponseStructure<Address> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Found successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.FOUND);
		}else {
			throw new NoSuchElementException("no id found");
		}
		
	}
}
