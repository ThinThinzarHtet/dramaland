package com.ttzh.drama.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ttzh.drama.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
