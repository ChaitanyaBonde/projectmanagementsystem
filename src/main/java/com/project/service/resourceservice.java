package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.resource;
import com.project.repo.resourcerepo;

@Service
public class resourceservice {

	@Autowired
	public resourcerepo repo;
	
	public resource save(resource resource) {
		// TODO Auto-generated method stub
		return repo.save(resource);
	}

	public List<resource> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Optional<resource> findById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}
}
