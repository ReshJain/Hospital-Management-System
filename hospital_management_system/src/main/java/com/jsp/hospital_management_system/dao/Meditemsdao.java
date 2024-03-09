package com.jsp.hospital_management_system.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hospital_management_system.dto.Meditems;
import com.jsp.hospital_management_system.dto.Medorder;
import com.jsp.hospital_management_system.repo.MeditemsRepo;
import com.jsp.hospital_management_system.repo.MedorderRepo;
@Repository
public class Meditemsdao {
	
	@Autowired
	private Medorderdao medorderdao;
	
	@Autowired
	private MeditemsRepo meditemsRepo;

	public Meditems saveMeditems(Meditems meditems, int mid) {
		Medorder medorder = medorderdao.getMedorderbyid(mid);
		meditems.setMedorder(medorder);
		return meditemsRepo.save(meditems);

	}
	public Meditems updateMeditems(int id,Meditems meditems) {
		if(meditemsRepo.findById(id).isPresent()) {
			meditems.setId(id);
			return meditemsRepo.save(meditems);
		}else {
			return null;
		}
		
	}
	public Meditems deleteMeditems(int id) {
		if(meditemsRepo.findById(id).isPresent()) {
			Meditems meditems=meditemsRepo.findById(id).get();
			meditemsRepo.deleteById(id);
			return meditems;
		}else {
			return null;
		}
		
	}
	public Meditems getMeditemsbyid(int id) {
		return meditemsRepo.findById(id).get();
		
	}
}


