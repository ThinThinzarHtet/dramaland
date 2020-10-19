package com.ttzh.drama.model;



import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Dramas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long drama_id;
	private String title;
	private String description;
	@Temporal(TemporalType.DATE)
	private Date released_date;
	
	@OneToMany(
			mappedBy = "dramaId",
			fetch = FetchType.LAZY,
			cascade = CascadeType.REMOVE
	)
	private Set<Seasons> seasons = new HashSet <Seasons>();
	
	@ManyToMany
	@JoinTable(
		name = "drama_genre",
		joinColumns = @JoinColumn(name = "drama_id"),
		inverseJoinColumns = @JoinColumn(name= "genre_id")
	)
	private Set<Genre> genres;
	
	@ManyToMany
	@JoinTable(
		name = "production_company",
		joinColumns = @JoinColumn(name = "drama_id"),
		inverseJoinColumns = @JoinColumn(name = "company_id")
	)
	private Set<Company> companies;
	
	@OneToMany(
		cascade = CascadeType.REMOVE,
		fetch = FetchType.LAZY,
		mappedBy = "dramas"
	)
	private List<DramaCrew> crews;
	
	public Long getDrama_id() {
		return drama_id;
	}
	public void setDrama_id(Long drama_id) {
		this.drama_id = drama_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getReleased_date() {
		return released_date;
	}
	public void setReleased_date(Date released_date) {
		this.released_date = released_date;
	}
	
	public Set<Genre> getGenres() {
		return genres;
	}
	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}
	public Set<Company> getCompanies() {
		return companies;
	}
	public void setCompanies(Set<Company> companies) {
		this.companies = companies;
	}
	public Set<Seasons> getSeasons() {
		return seasons;
	}
	public void setSeasons(Set<Seasons> seasons) {
		this.seasons = seasons;
	}
	public List<DramaCrew> getCrews() {
		return crews;
	}
	public void setCrews(List<DramaCrew> crews) {
		this.crews = crews;
	}
	
}
