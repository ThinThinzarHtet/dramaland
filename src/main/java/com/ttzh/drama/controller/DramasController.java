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

import com.ttzh.drama.model.Dramas;
import com.ttzh.drama.repository.DramasRepository;
import com.ttzh.drama.repository.GenreRepository;
import com.ttzh.drama.repository.PersonRepository;

@RestController
@CrossOrigin
@RequestMapping("dramas")
public class DramasController {
	@Autowired
	DramasRepository dramasRepository;
	@Autowired
	GenreRepository genreRepository;
	@Autowired
	PersonRepository personRepository;
	
	@GetMapping
	public List<Dramas> getAll(){
		return dramasRepository.findAll();
	}
	
	@GetMapping("{drama_id}")
	public Dramas getById(@PathVariable Long drama_id) {
		return dramasRepository.getOne(drama_id);
	}
	
	@PostMapping
	public Dramas save(@RequestBody Dramas dramas) {
		return dramasRepository.saveAndFlush(dramas);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Dramas update(@RequestBody Dramas dramas) {
		Dramas oldDramas = dramasRepository.getOne(dramas.getDrama_id());
		BeanUtils.copyProperties(dramas, oldDramas, "drama_id");
		return dramasRepository.saveAndFlush(oldDramas);
	}
	
	@RequestMapping(value = "{drama_id}", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable Long drama_id) {
		dramasRepository.deleteById(drama_id);
	}
}
