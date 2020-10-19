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

import com.ttzh.drama.model.Episodes;
import com.ttzh.drama.repository.EpisodesRepository;

@CrossOrigin
@RestController
@RequestMapping("Episodes")
public class EpisodesController {
	@Autowired
	EpisodesRepository episodesRepository;
	
	@GetMapping
	public List<Episodes> getAll(){
		return episodesRepository.findAll();
	}

	@GetMapping("{episode_id}")
	public Episodes getById(@PathVariable Long episode_id) {
		return episodesRepository.getOne(episode_id);
	}
	
	@PostMapping
	public Episodes save(@RequestBody Episodes episode) {
		return episodesRepository.saveAndFlush(episode);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	  public Episodes update(@RequestBody Episodes episodes) {
	    Episodes oldEpisode = episodesRepository.getOne(episodes.getEpisode_id());
	    BeanUtils.copyProperties(episodes, oldEpisode, "id");
	    return episodesRepository.saveAndFlush(oldEpisode);
	  }
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable Long episode_id) {
		episodesRepository.deleteById(episode_id);
	}
}
