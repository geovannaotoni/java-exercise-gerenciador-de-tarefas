package com.betrybe.taskmanager.service;

import com.betrybe.taskmanager.database.TaskDatabaseInterface;
import com.betrybe.taskmanager.dto.TaskDto;
import com.betrybe.taskmanager.model.TaskModel;
import java.util.ArrayList;
import java.util.List;
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
      allTasksDto.add(new TaskDto(
          task.getId(),
          task.getTitle(),
          task.getDescription(),
          task.getOwnerName(),
          task.getIsCompleted())
      );
    }
    return allTasksDto;
  }

  /**
   * Gets task by id.
   *
   * @param id the id
   * @return the task by id
   */
  public TaskDto getTaskById(String id) {
    TaskModel taskModel = database.getTaskById(id);
    return new TaskDto(
        taskModel.getId(),
        taskModel.getTitle(),
        taskModel.getDescription(),
        taskModel.getOwnerName(),
        taskModel.getIsCompleted()
    );
  }
}
