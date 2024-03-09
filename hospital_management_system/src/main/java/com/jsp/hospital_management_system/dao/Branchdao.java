package com.jsp.hospital_management_system.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hospital_management_system.dto.Address;
import com.jsp.hospital_management_system.dto.Branch;
import com.jsp.hospital_management_system.dto.Hospital;
import com.jsp.hospital_management_system.repo.BranchRepo;

@Repository
public class Branchdao {

	@Autowired
	private BranchRepo branchRepo;
	
	@Autowired
	private Hospitaldao hospitaldao;
	
	@Autowired
	private Addressdao addressdao;
	
	public Branch saveBranch(int hid,int aid,Branch branch) {
		Hospital hospital=hospitaldao.getHospitalbyid(hid);
		branch.setHospital(hospital);
		Address address=addressdao.getaddressbyid(aid);
		branch.setAddress(address);
		return branchRepo.save(branch);
		
	}
	public Branch updateBranch(int id,Branch branch) {
		Branch dbbranch=branchRepo.findById(id).get();
		if(dbbranch!=null) {
			branch.setId(id);
			branch.setHospital(dbbranch.getHospital());
			branch.setAddress(dbbranch.getAddress());
			return branchRepo.save(branch);
		}else {
			return null;
		}
		
	}
	public Branch deleteBranch(int id) {
		if(branchRepo.findById(id).isPresent()) {
			Branch branch=branchRepo.findById(id).get();
			branchRepo.deleteById(id);
			return branch;
		}else {
			return null;
		}
		
	}
	public Branch getbranchbyid(int id) {
		if(branchRepo.findById(id).isPresent()) {
			return branchRepo.findById(id).get();
		}else {
			return null;
		}
			
		
	}
	public List<Branch> getallBranchs() {
		return branchRepo.findAll();
	}
}
