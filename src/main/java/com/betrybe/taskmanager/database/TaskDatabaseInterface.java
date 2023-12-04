package com.betrybe.taskmanager.database;

import com.betrybe.taskmanager.model.TaskModel;
import java.util.List;
import java.util.Optional;

/**
 * Defines an interface for possible implementations of databases for CRUD operations in the Task
 * model.
 */
public interface TaskDatabaseInterface {
  List<TaskModel> getAllTasks();

  Optional<TaskModel> getTaskById(String id);

  TaskModel createTask(String title, String description, String ownerName);

  TaskModel setTaskAsCompleted(String id);

  TaskModel removeTaskById(String id);
}
