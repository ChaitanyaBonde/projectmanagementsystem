package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.project;
import com.project.repo.projectrepo;

@Service
public class projectservice {

	@Autowired
	public projectrepo repo;

	public project save(project pro) {
		// TODO Auto-generated method stub
		return repo.save(pro);
	}

	public List<project> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Optional<project> findById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}
}
