package com.betrybe.taskmanager.service;

import com.betrybe.taskmanager.database.TaskDatabaseInterface;
import com.betrybe.taskmanager.dto.TaskCreationDto;
import com.betrybe.taskmanager.dto.TaskDto;
import com.betrybe.taskmanager.model.TaskModel;
import com.betrybe.taskmanager.utils.ModelDtoConverter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Task service.
 */
@Service
public class TaskService {
  private TaskDatabaseInterface database;

  @Autowired
  public TaskService(TaskDatabaseInterface database) {
    this.database = database;
  }

  /**
   * Gets all tasks.
   *
   * @return the all tasks
   */
  public List<TaskDto> getAllTasks() {
    List<TaskModel> allTasks = database.getAllTasks();
    List<TaskDto> allTasksDto = new ArrayList<>();

    for (TaskModel task : allTasks) {
      allTasksDto.add(ModelDtoConverter.modelToDtoTask(task));
    }
    return allTasksDto;
  }

  /**
   * Gets task by id.
   *
   * @param id the id
   * @return the task by id
   */
  public Optional<TaskDto> getTaskById(String id) {
    Optional<TaskModel> taskModel = database.getTaskById(id);
    if (taskModel.isEmpty()) {
      return Optional.empty();
    }
    return Optional.of(ModelDtoConverter.modelToDtoTask(taskModel.orElse(null)));
  }

  /**
   * Create task task dto.
   *
   * @param newTask the new task
   * @return the task dto
   */
  public String createTask(TaskCreationDto newTask) {
    TaskModel taskModel = database.createTask(
        newTask.title(),
        newTask.description(),
        newTask.ownerName()
    );
    return ModelDtoConverter.modelToDtoTask(taskModel).id();
  }

  public TaskDto setTaskAsCompleted(String id) {
    TaskModel updatedTask = database.setTaskAsCompleted(id);
    return  ModelDtoConverter.modelToDtoTask(updatedTask);
  }

  public TaskDto removeTaskById(String id) {
    TaskModel removedTask = database.removeTaskById(id);
    return ModelDtoConverter.modelToDtoTask(removedTask);
  }
}
