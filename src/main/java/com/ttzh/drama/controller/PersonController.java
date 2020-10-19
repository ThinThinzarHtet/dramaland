package com.ttzh.drama.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ttzh.drama.model.Person;
import com.ttzh.drama.repository.PersonRepository;

@CrossOrigin
@RestController
@RequestMapping("Person")
public class PersonController {
	@Autowired
	PersonRepository personRepository;
	
	@GetMapping
	public List<Person> getAll(){
		return personRepository.findAll();
	}
	
	@GetMapping("{person_id}")
	public Person getById(@PathVariable Long person_id) {
		return personRepository.getOne(person_id);
	}
	
	@PostMapping
	public Person save(@RequestBody Person person) {
		return personRepository.saveAndFlush(person);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	  public Person update(@RequestBody Person person) {
		Person oldPerson = personRepository.getOne(person.getPerson_id());
	    BeanUtils.copyProperties(person, oldPerson, "person_id");
	    return personRepository.saveAndFlush(oldPerson);
	  }
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable Long person_id) {
		personRepository.deleteById(person_id);
	}
}
