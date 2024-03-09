package com.jsp.hospital_management_system.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hospital_management_system.dao.Meditemsdao;
import com.jsp.hospital_management_system.dto.Branch;
import com.jsp.hospital_management_system.dto.Meditems;
import com.jsp.hospital_management_system.exception.IdNotFoundException;
import com.jsp.hospital_management_system.util.ResponseStructure;

@Service
public class Meditemservice {

	@Autowired
	private Meditemsdao meditemsdao;
	
	public ResponseEntity<ResponseStructure<Meditems>> saveMeditems(Meditems meditems,int mid) {
		ResponseStructure<Meditems> responseStructure = new ResponseStructure<Meditems>();
		responseStructure.setMessage("successfull saved ");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(meditemsdao.saveMeditems(meditems, mid));
		return new ResponseEntity<ResponseStructure<Meditems>>(responseStructure,HttpStatus.CREATED);
		
	}
	public ResponseEntity<ResponseStructure<Meditems>> updteMeditems(int id,Meditems meditems) {
		Meditems dbMeditems=meditemsdao.getMeditemsbyid(id);
		meditems.setMedorder(dbMeditems.getMedorder());
		Meditems meditems2=meditemsdao.updateMeditems(id, meditems);
		if(meditems2!=null){
			ResponseStructure<Meditems> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("successfully updated");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dbMeditems);
			return new ResponseEntity<ResponseStructure<Meditems>>(responseStructure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException("id not found for Meditems");
		}
		
	}
	public ResponseEntity<ResponseStructure<Meditems>> deleteMeditems(int id) {
		Meditems meditems=meditemsdao.deleteMeditems(id);
		if(meditems!=null) {
			ResponseStructure<Meditems> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("successfully updated");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(meditems);
			return new ResponseEntity<ResponseStructure<Meditems>>(responseStructure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException("id not found ");
		}
		
	}
	public ResponseEntity<ResponseStructure<Meditems>> getMeditemsbyid(int id) {
		Meditems meditems=meditemsdao.getMeditemsbyid(id);
		if(meditems!=null) {
			ResponseStructure<Meditems> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Found successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(meditems);
			return new ResponseEntity<ResponseStructure<Meditems>>(responseStructure,HttpStatus.FOUND);
		}else {
			throw new NoSuchElementException("no id found");
		}
		
	}
}


