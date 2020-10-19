package com.ttzh.drama.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Episodes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long episode_id;
	private String episode_name;
	private String runtime;
	@Column(name = "season_id", nullable = false)
	private Long seasonId;
	public Long getEpisode_id() {
		return episode_id;
	}
	public void setEpisode_id(Long episode_id) {
		this.episode_id = episode_id;
	}
	public String getEpisode_name() {
		return episode_name;
	}
	public void setEpisode_name(String episode_name) {
		this.episode_name = episode_name;
	}
	public String getRuntime() {
		return runtime;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	public Long getSeasonId() {
		return seasonId;
	}
	public void setSeasonId(Long seasonId) {
		this.seasonId = seasonId;
	}
	
}
