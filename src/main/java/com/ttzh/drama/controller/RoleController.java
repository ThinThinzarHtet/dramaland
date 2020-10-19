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

import com.ttzh.drama.model.Role;
import com.ttzh.drama.repository.RoleRepository;

@CrossOrigin
@RestController
@RequestMapping("Role")
public class RoleController {
	@Autowired
	RoleRepository roleRepository;
	
	@GetMapping
	public List<Role> getAll(){
		return roleRepository.findAll();
	}
	
	@GetMapping("{role_id}")
	public Role getById(@PathVariable Long role_id) {
		return roleRepository.getOne(role_id);
	}
	
	@PostMapping
	public Role save(@RequestBody Role role) {
		return roleRepository.saveAndFlush(role);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	  public Role update(@RequestBody Role role) {
		Role oldRole = roleRepository.getOne(role.getRole_id());
	    BeanUtils.copyProperties(role, oldRole, "role_id");
	    return roleRepository.saveAndFlush(oldRole);
	  }
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable Long person_id) {
		roleRepository.deleteById(person_id);
	}
}
