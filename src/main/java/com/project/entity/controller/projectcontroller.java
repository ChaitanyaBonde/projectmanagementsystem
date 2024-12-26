package com.project.entity.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.project;
import com.project.service.projectservice;

@RestController
@RequestMapping("/project")
public class projectcontroller {

	@Autowired
	public projectservice service;
	
	
	@PostMapping
	public project save(@RequestBody project pro) {
		return service.save(pro);
	}
	
	@GetMapping
	public List<project> getall(){
		return service.findAll();
		
	}
	
	@GetMapping("/{id}")
	public Optional<project> getbyid(@PathVariable int id){
		return service.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public String delet(@PathVariable int id) {
		service.deleteById(id);
		return "deleted";
	}
	
	
	
   
	
	
}






















