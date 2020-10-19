package com.ttzh.drama.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ttzh.drama.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
