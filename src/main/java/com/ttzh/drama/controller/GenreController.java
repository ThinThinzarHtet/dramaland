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

import com.ttzh.drama.model.Genre;
import com.ttzh.drama.repository.GenreRepository;

@RestController
@CrossOrigin
@RequestMapping("genre")
public class GenreController {
	@Autowired
	GenreRepository genreRepository;
	
	@GetMapping
	public List<Genre> getAll(){
		return genreRepository.findAll();
	}
	
	@GetMapping("{genre_id}")
	public Genre getById(@PathVariable Long genre_id) {
		return genreRepository.getOne(genre_id);
	}
	
	@PostMapping
	public Genre save(@RequestBody Genre genre) {
		return genreRepository.saveAndFlush(genre);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	  public Genre update(@RequestBody Genre genre) {
	    Genre oldGenre = genreRepository.getOne(genre.getGenre_id());
	    BeanUtils.copyProperties(genre, oldGenre, "genre_id");
	    return genreRepository.saveAndFlush(oldGenre);
	  }
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable Long genre_id) {
		genreRepository.deleteById(genre_id);
	}
}
