package com.ttzh.drama.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Genre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long genre_id;
	private String genre_type;
	public Long getGenre_id() {
		return genre_id;
	}
	public void setGenre_id(Long genre_id) {
		this.genre_id = genre_id;
	}
	public String getGenre_type() {
		return genre_type;
	}
	public void setGenre_name(String genre_type) {
		this.genre_type = genre_type;
	}
}
