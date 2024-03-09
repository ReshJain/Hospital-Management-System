package com.jsp.hospital_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hospital_management_system.dto.Hospital;
import com.jsp.hospital_management_system.repo.HospitalRepo;

@Repository
public class Hospitaldao {

	@Autowired
	private HospitalRepo hospitalRepo;
	
	public Hospital saveHospital(Hospital hospital) {
		return hospitalRepo.save(hospital);
	}
	
	public Hospital updateHospital(int id,Hospital hospital) {
		if(hospitalRepo.findById(id).isPresent()) {
			hospital.setId(id);
			return hospitalRepo.save(hospital);
		}else {
			return null;
		}
	}
	public Hospital deleteHospital(int id) {
		if(hospitalRepo.findById(id).isPresent()) {
			Hospital hospital = hospitalRepo.findById(id).get();
			hospitalRepo.deleteById(id);
			return hospital;
		}else {
			return null;
		}
	}
	public Hospital getHospitalbyid(int id) {
		Optional<Hospital> hospital=hospitalRepo.findById(id);
		if(hospital.isPresent()) {
			return hospital.get();
		}else {
			return null;
		}
		
	}
	public List<Hospital> getallHospitals() {
		return hospitalRepo.findAll();
	}
}



