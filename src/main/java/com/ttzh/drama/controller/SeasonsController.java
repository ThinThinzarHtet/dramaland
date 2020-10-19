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

import com.ttzh.drama.model.Seasons;
import com.ttzh.drama.repository.SeasonsRepository;

@CrossOrigin
@RestController
@RequestMapping("Seasons")
public class SeasonsController {
	@Autowired
	SeasonsRepository seasonsRepository;
	
	@GetMapping
	public List<Seasons> getAll(){
		return seasonsRepository.findAll();
	}
	
	@GetMapping("{season_id}")
	public Seasons getById(@PathVariable Long season_id) {
		return seasonsRepository.getOne(season_id);
	}
	
	@PostMapping
	public Seasons save(@RequestBody Seasons season) {
		return seasonsRepository.saveAndFlush(season);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	  public Seasons update(@RequestBody Seasons season) {
		Seasons oldSeason = seasonsRepository.getOne(season.getSeason_id());
	    BeanUtils.copyProperties(season, oldSeason, "season_id");
	    return seasonsRepository.saveAndFlush(oldSeason);
	  }
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable Long season_id) {
		seasonsRepository.deleteById(season_id);
	}
}
