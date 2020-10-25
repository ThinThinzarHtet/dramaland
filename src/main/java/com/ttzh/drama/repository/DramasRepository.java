package com.ttzh.drama.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.ttzh.drama.model.Dramas;
import com.ttzh.drama.model.Genre;

@Repository
public interface DramasRepository extends JpaRepository<Dramas, Long> {
	/*public List<Dramas> findByGenres_GenreId(Long genreId)*/
}
