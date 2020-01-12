package com.mt.spring.oauthokta.controllers;

import com.mt.spring.oauthokta.model.Task;
import com.mt.spring.oauthokta.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/tasks")
@Api(value="Tasks Management Feature")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    @ApiOperation(value = "Create or update a new task", response = Task.class)
    public ResponseEntity<Task> save(@RequestBody Task task) {
        taskService.save(task.getId(), task);
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete the task with the given id", response = String.class)
    public ResponseEntity<String> delete(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.ok("Task deleted successfully");
    }

    @GetMapping
    @ApiOperation(value = "Get all tasks", response = Collection.class)
    public ResponseEntity<Collection<Task>> findAll() {
        return ResponseEntity.ok(taskService.findAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get the task with the given id", response = Task.class)
    public ResponseEntity<Task> findById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.findById(id));
    }
}
