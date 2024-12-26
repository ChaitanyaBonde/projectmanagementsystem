package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.project;
import com.project.entity.resource;
import com.project.entity.task;
import com.project.repo.projectrepo;
import com.project.repo.resourcerepo;
import com.project.repo.taskrepo;

@Service
public class validationservice {

	@Autowired
	public projectrepo prorepo;
	
	@Autowired
	public taskrepo trepo;
	
	@Autowired
	public resourcerepo Rrepo;
	
	public String taskforproject(int projectid, task task) {
		project project  = prorepo.findById(projectid).orElse(null);
		
		if(project != null) {
			task.setProject(project);
			trepo.save(task);
			return "task added in project";
		}
		return "problem with project";
	}
	
	public String addresourcetotask(int taskid, int resoureid) {
		task task = trepo.findById(taskid).get();
		resource resource = Rrepo.findById(resoureid).get();
		if(!"Available".equalsIgnoreCase(resource.getStatus())) {
			return "resource not available";
		}
		
		long taskcount = task.getProject().getTasks().stream().filter(t -> t.getResources().contains(resource)).count();
		if(taskcount >= 2) {
			return "Resource is already 2 tasks in this project.";
		}
		
		task.getResources().add(resource);
		trepo.save(task);
		return "task added for Resource  ";
	}
	
}
