package com.mt.spring.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mt.spring.security.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
