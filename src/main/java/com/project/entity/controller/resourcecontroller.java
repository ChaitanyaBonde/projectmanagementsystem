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

import com.project.entity.resource;
import com.project.service.resourceservice;

@RestController
@RequestMapping("/resource")
public class resourcecontroller {

	@Autowired
	public resourceservice service;
	
	@PostMapping
	public resource save(@RequestBody resource resource) {
		return service.save(resource);
	}
	
	@GetMapping
	public List<resource> getall(){
		return service.findAll();
		
	}
	
	@GetMapping("/{id}")
	public Optional<resource> getbyid(@PathVariable int id){
		return service.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public String delet(@PathVariable int id) {
		service.deleteById(id);
		return "deleted";
	}
}
