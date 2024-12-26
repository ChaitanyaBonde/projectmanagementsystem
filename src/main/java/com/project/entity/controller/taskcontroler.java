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

import com.project.entity.task;
import com.project.service.validationservice;
import com.project.service.taskservice;

@RestController
@RequestMapping("/task")
public class taskcontroler {

	@Autowired
	public taskservice service;
	
	@Autowired
	public validationservice validationservice;
	
	@PostMapping
	public task save(@RequestBody task task) {
		return service.save(task);
	}
	
	@GetMapping
	public List<task> getall(){
		return service.findAll();
		
	}
	
	@GetMapping("/{id}")
	public Optional<task> getbyid(@PathVariable int id){
		return service.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public String delet(@PathVariable int id) {
		service.deleteById(id);
		return "deleted";
	}
	//-----------------------------------------------------------
	@PostMapping("/projectid/{projectid}")
	public String createtaskforproject(@PathVariable int projectid, @RequestBody task task) {
		return validationservice.taskforproject(projectid, task);	
	}

	@PostMapping("/{taskid}/resource/{resourceid}")
	public String assignreource(@PathVariable int taskid, @PathVariable int resourceid) {
		return validationservice.addresourcetotask(taskid, resourceid);
	}
	
}













