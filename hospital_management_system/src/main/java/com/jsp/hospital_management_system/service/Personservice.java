package com.jsp.hospital_management_system.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hospital_management_system.dao.Persondao;
import com.jsp.hospital_management_system.dto.Medorder;
import com.jsp.hospital_management_system.dto.Person;
import com.jsp.hospital_management_system.exception.IdNotFoundException;
import com.jsp.hospital_management_system.util.ResponseStructure;

import antlr.collections.List;

@Service
public class Personservice {

	@Autowired
	private Persondao persondao;
	
	public ResponseEntity<ResponseStructure<Person>> savePerson(Person person) {
		ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();
		responseStructure.setMessage("successfull saved ");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(persondao.savePerson(person));
		return new ResponseEntity<ResponseStructure<Person>>(responseStructure,HttpStatus.CREATED);
		
	}
	public ResponseEntity<ResponseStructure<Person>>  updatePerson(int id,Person person) {
		Person dbPerson=persondao.updatePerson(id, person);
		if(dbPerson!=null) {
			ResponseStructure<Person> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("successfully updated");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dbPerson);
			return new ResponseEntity<ResponseStructure<Person>>(responseStructure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException("id not found for Person");
		}
	}
	
	public ResponseEntity<ResponseStructure<Person>> deletePerson(int id) {
		Person person = persondao.deletePerson(id);
		if(person!=null) {
			ResponseStructure<Person> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("successfully updated");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(person);
			return new ResponseEntity<ResponseStructure<Person>>(responseStructure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException("id not found ");
		}
	}
	
	public ResponseEntity<ResponseStructure<Person>>  getPersonbyid(int id) {
		Person person = persondao.getPersonbyid(id);
		if(person!=null) {
			ResponseStructure<Person> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Found successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(person);
			return new ResponseEntity<ResponseStructure<Person>>(responseStructure,HttpStatus.FOUND);
		}else {
			throw new NoSuchElementException("no id found");
		}
	}
	
}
