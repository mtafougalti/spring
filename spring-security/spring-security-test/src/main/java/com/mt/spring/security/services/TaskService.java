package com.mt.spring.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mt.spring.security.entities.Task;
import com.mt.spring.security.repositories.TaskRepository;

@RestController
@RequestMapping("/tasks")
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	@GetMapping
	public List<Task> list(){
		return taskRepository.findAll();
	}
	
	@PostMapping("/add")
	public Task add (@RequestBody Task task) {
		return taskRepository.save(task);
	}
	
	@DeleteMapping("/delete")
	public void delete (Long id) {
		Task task = taskRepository.findById(id).get();
		taskRepository.delete(task);
	}

}
