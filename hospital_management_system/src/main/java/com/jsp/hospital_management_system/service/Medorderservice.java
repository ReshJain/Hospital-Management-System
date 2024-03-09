package com.jsp.hospital_management_system.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hospital_management_system.dao.Medorderdao;
import com.jsp.hospital_management_system.dto.Meditems;
import com.jsp.hospital_management_system.dto.Medorder;
import com.jsp.hospital_management_system.exception.IdNotFoundException;
import com.jsp.hospital_management_system.util.ResponseStructure;

@Service
public class Medorderservice {

	@Autowired
	private Medorderdao medorderdao;
	
	public ResponseEntity<ResponseStructure<Medorder>>  saveMedorder(Medorder medorder,int eid) {
		ResponseStructure<Medorder> responseStructure = new ResponseStructure<Medorder>();
		responseStructure.setMessage("successfull saved ");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(medorderdao.saveMedorder(medorder, eid));
		return new ResponseEntity<ResponseStructure<Medorder>>(responseStructure,HttpStatus.CREATED);
		
		
	}
	public ResponseEntity<ResponseStructure<Medorder>> updateMedorder(int id,Medorder medorder) {
		Medorder dbMedorder=medorderdao.getMedorderbyid(id);
		medorder.setEncounter(dbMedorder.getEncounter());
		Medorder medorder2=medorderdao.updateMedorder(id, medorder);
		if(medorder2!=null) {
			ResponseStructure<Medorder> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("successfully updated");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dbMedorder);
			return new ResponseEntity<ResponseStructure<Medorder>>(responseStructure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException("id not found for medorder");
		}
		
	}
	public ResponseEntity<ResponseStructure<Medorder>> deleteMedorder(int id) {
		Medorder medorder=medorderdao.deleteMedorder(id);
		if(medorder!=null) {
			ResponseStructure<Medorder> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("successfully updated");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(medorder);
			return new ResponseEntity<ResponseStructure<Medorder>>(responseStructure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException("id not found");
		}
		
	}
	public ResponseEntity<ResponseStructure<Medorder>> getMedorderbyid(int id) {
		Medorder medorder=medorderdao.getMedorderbyid(id);
		if(medorder!=null) {
			ResponseStructure<Medorder> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Found successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(medorder);
			return new ResponseEntity<ResponseStructure<Medorder>>(responseStructure,HttpStatus.FOUND);
		}else {
			throw new NoSuchElementException("no id found");
		}
		
	}
}

