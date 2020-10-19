package com.ttzh.drama.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ttzh.drama.model.Dramas;

public interface DramasRepository extends JpaRepository<Dramas, Long> {

}
