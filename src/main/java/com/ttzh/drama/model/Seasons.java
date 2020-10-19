package com.ttzh.drama.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Seasons {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long season_id;
	private String season_name;
	@Column(name = "drama_id", nullable = false)
	private Long  dramaId;
	
	
	@OneToMany(
		cascade = CascadeType.REMOVE,
		fetch = FetchType.LAZY,
		mappedBy = "seasonId"
	)
	private List<Episodes> episode;
	
	
	
	public Long getSeason_id() {
		return season_id;
	}
	public void setSeason_id(Long season_id) {
		this.season_id = season_id;
	}
	public String getSeason_name() {
		return season_name;
	}
	public void setSeason_name(String season_name) {
		this.season_name = season_name;
	}
	public List<Episodes> getEpisode() {
		return episode;
	}
	public void setEpisode(List<Episodes> episode) {
		this.episode = episode;
	}
	public Long getDramaId() {
		return dramaId;
	}
	public void setDramaId(Long dramaId) {
		this.dramaId = dramaId;
	}
	
	
}
