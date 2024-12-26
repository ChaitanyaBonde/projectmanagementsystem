package com.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.task;

public interface taskrepo extends JpaRepository<task, Integer> {

}
