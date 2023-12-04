package com.betrybe.taskmanager.utils;

import com.betrybe.taskmanager.dto.TaskDto;
import com.betrybe.taskmanager.model.TaskModel;

/**
 * The type Model dto converter.
 */
public class ModelDtoConverter {

  /**
   * Model to dto task task dto.
   *
   * @param taskModel the task model
   * @return the task dto
   */
  public static TaskDto modelToDtoTask(TaskModel taskModel) {
    return new TaskDto(
        taskModel.getId(),
        taskModel.getTitle(),
        taskModel.getDescription(),
        taskModel.getOwnerName(),
        taskModel.getIsCompleted()
    );
  }
}
