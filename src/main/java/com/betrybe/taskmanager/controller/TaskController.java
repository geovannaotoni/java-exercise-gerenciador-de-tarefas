package com.betrybe.taskmanager.controller;

import com.betrybe.taskmanager.dto.TaskCreationDto;
import com.betrybe.taskmanager.dto.TaskDto;
import com.betrybe.taskmanager.model.TaskModel;
import com.betrybe.taskmanager.service.TaskService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Task controller.
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {
  private TaskService service;

  @Autowired
  public TaskController(TaskService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<TaskDto>> getAllTasks() {
    List<TaskDto> allTasks = service.getAllTasks();
    return ResponseEntity.ok(allTasks);
  }

  /**
   * Gets task by id.
   *
   * @param id the id
   * @return the task by id
   */
  @GetMapping("/{id}")
  public ResponseEntity<Optional<TaskDto>> getTaskById(@PathVariable String id) {
    Optional<TaskDto> taskById = service.getTaskById(id);
    if (taskById.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(taskById);
  }

  @PostMapping
  public ResponseEntity<String> createTask(@RequestBody TaskCreationDto newTask) {
    String taskId = service.createTask(newTask);
    return ResponseEntity.status(HttpStatus.CREATED).body(taskId);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> setTaskAsCompleted(@PathVariable String id) {
    service.setTaskAsCompleted(id);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> removeTaskById(@PathVariable String id) {
    service.removeTaskById(id);
    return ResponseEntity.noContent().build();
  }
}
