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

import com.ttzh.drama.model.Company;
import com.ttzh.drama.repository.CompanyRepository;

@CrossOrigin
@RestController
@RequestMapping("Company")
public class CompanyController {
	@Autowired
	CompanyRepository companyRepository;
	
	@GetMapping
	public List<Company> getAll(){
		return companyRepository.findAll();
	}
	
	@GetMapping("{company_id}")
	public Company getById(@PathVariable Long company_id) {
		return companyRepository.getOne(company_id);
	}
	
	@PostMapping
	public Company save(@RequestBody Company company) {
		return companyRepository.saveAndFlush(company);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	  public Company update(@RequestBody Company company) {
		Company oldCompany = companyRepository.getOne(company.getCompany_id());
	    BeanUtils.copyProperties(company, oldCompany, "company_id");
	    return companyRepository.saveAndFlush(oldCompany);
	  }
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable Long company_id) {
		companyRepository.deleteById(company_id);
	}
}
