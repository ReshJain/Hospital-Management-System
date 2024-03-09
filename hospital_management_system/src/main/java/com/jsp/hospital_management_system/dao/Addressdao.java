package com.jsp.hospital_management_system.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hospital_management_system.dto.Address;
import com.jsp.hospital_management_system.repo.AddressRepo;

import antlr.collections.List;
import ch.qos.logback.core.joran.conditional.IfAction;

@Repository
public class Addressdao {

	@Autowired
	private AddressRepo addressrepo;
	
	public Address saveAddress(Address address) {
		return addressrepo.save(address);
	}
	public Address updateAddress(int id,Address address) {
		if(addressrepo.findById(id).isPresent()) {
			address.setId(id);
			return addressrepo.save(address);
			
		}else {
			return null;
		}
	}
	public Address deleteAddress(int id) {
		if(addressrepo.findById(id).isPresent()) {
			Address address=addressrepo.findById(id).get();
			addressrepo.deleteById(id);
			return address;
		}else {
			return null;
		}
		
	}
	public Address getaddressbyid(int id) {
		if(addressrepo.findById(id).isPresent()) {
			return addressrepo.findById(id).get();
		}else {
			return null;
		}
		
	}
	
		
	}




