package com.jsp.hospital_management_system.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hospital_management_system.dto.Person;
import com.jsp.hospital_management_system.repo.PersonRepo;

@Repository
public class Persondao {

	@Autowired
	private PersonRepo personRepo;

	public Person savePerson(Person person) {
		return personRepo.save(person);

	}

	public Person updatePerson(int id, Person person) {
		if (personRepo.findById(id).isPresent()) {
			person.setId(id);
			return personRepo.save(person);
		} else {
			return null;
		}

	}

	public Person deletePerson(int id) {
		if (personRepo.findById(id).isPresent()) {
			Person person = personRepo.findById(id).get();
			personRepo.deleteById(id);
			return person;
		} else {
			return null;
		}

	}

	public Person getPersonbyid(int id) {
		if (personRepo.findById(id).isPresent()) {
			return personRepo.findById(id).get();
		} else {
			return null;
		}

	}

	public List<Person> getallperson() {
		return personRepo.findAll();
	}
}


