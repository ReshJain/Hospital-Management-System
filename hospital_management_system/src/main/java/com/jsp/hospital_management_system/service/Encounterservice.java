package com.jsp.hospital_management_system.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jsp.hospital_management_system.dao.Branchdao;
import com.jsp.hospital_management_system.dao.Encounterdao;
import com.jsp.hospital_management_system.dao.Persondao;
import com.jsp.hospital_management_system.dto.Branch;
import com.jsp.hospital_management_system.dto.Encounter;
import com.jsp.hospital_management_system.dto.Person;
import com.jsp.hospital_management_system.exception.IdNotFoundException;
import com.jsp.hospital_management_system.util.ResponseStructure;

@Service
public class Encounterservice {

	@Autowired
	private Encounterdao encounterdao;
	
	@Autowired
	private Persondao persondao;
	
	@Autowired
	private Branchdao branchdao;
	
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(Encounter encounter,int pid,int bid) {
		Person person=persondao.getPersonbyid(pid);
		Branch branch=branchdao.getbranchbyid(bid);
		
		encounter.setPerson(person);
		List<Branch> list=new ArrayList<>();
		list.add(branch);
		encounter.setBranchs(list);
		
		ResponseStructure<Encounter> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("succesfully saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(encounterdao.savEncounter(encounter));
		
		return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure,HttpStatus.CREATED);
		
	}
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(int id,Encounter encounter,int bid) {
		Encounter dbEncounter=encounterdao.getEncounterbyId(id);
		Branch branch=branchdao.getbranchbyid(bid);
		
		List<Branch> list=dbEncounter.getBranchs();
		encounter.setBranchs(dbEncounter.getBranchs());
		encounter.setPerson(dbEncounter.getPerson());
		
		ResponseStructure<Encounter> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("updated succesfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(encounterdao.updatEncounter(id, dbEncounter));
		
		return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure,HttpStatus.OK);
		
	}
	
	public ResponseEntity<ResponseStructure<Encounter>> deletEncounter(int id) {
		Encounter encounter=encounterdao.deletEncounter(id);
		if(encounter!=null) {
			ResponseStructure<Encounter> responseStructure=new ResponseStructure<>();
			responseStructure.setMessage("deleted succesfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(encounter);
			return new  ResponseEntity<ResponseStructure<Encounter>>(responseStructure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException("id not found for Encounter");
		}
		
	}
	public ResponseEntity<ResponseStructure<Encounter>> getEncounterbyid(int id) {
		Encounter encounter=encounterdao.getEncounterbyId(id);
		if(encounter!=null) {
			ResponseStructure<Encounter> responseStructure=new ResponseStructure<>();
			responseStructure.setMessage("found succesfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(encounter);
			return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure,HttpStatus.FOUND);
		}else {
			throw new NoSuchElementException("no id found");
		}
		
	}
}
