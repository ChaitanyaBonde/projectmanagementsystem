package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.entity.task;
import com.project.repo.taskrepo;

@Service
public class taskservice {

	@Autowired
	public taskrepo repo;
	
	public task save(task task) {
		// TODO Auto-generated method stub
		return repo.save(task);
	}

	public List<task> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Optional<task> findById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}
}
