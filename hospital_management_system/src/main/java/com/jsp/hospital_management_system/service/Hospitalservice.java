package com.jsp.hospital_management_system.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hospital_management_system.dao.Hospitaldao;
import com.jsp.hospital_management_system.dto.Hospital;
import com.jsp.hospital_management_system.exception.IdNotFoundException;
import com.jsp.hospital_management_system.util.ResponseStructure;

@Service
public class Hospitalservice {

	@Autowired
	private Hospitaldao hospitaldao;
	
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital) {
		ResponseStructure<Hospital> responseStructure = new ResponseStructure<Hospital>();
		responseStructure.setMessage("successfull saved ");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(hospitaldao.saveHospital(hospital));
		return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.CREATED);
		
	}
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(int id,Hospital hospital) {
		Hospital dbHospital=hospitaldao.updateHospital(id, hospital);
		if(dbHospital!=null) {
			ResponseStructure<Hospital> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("successfully updated");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dbHospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException("id not found for hospital");
		}
		
	}
	public ResponseEntity<ResponseStructure<Hospital>>  deleteHospital(int id) {
		Hospital hospital=hospitaldao.deleteHospital(id);
		if(hospital!=null) {
			ResponseStructure<Hospital> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("successfully deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(hospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException("id not found");
		}
		
	}
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalbyid(int id) {
		Hospital hospital=hospitaldao.getHospitalbyid(id);
		if(hospital!=null) {
			ResponseStructure<Hospital> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Found successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(hospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.FOUND);
		}else {
			throw new NoSuchElementException("no id found");
		}
		
	}
}
