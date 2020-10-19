package com.ttzh.drama.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ttzh.drama.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
