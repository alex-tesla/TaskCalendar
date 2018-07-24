package com.devsav.service.interfaces;

import com.devsav.model.pojo.Task;

import java.util.List;

public interface TaskService {

    List<Task> getAllTasks();
    boolean setCompleteTask(int id);
    List<Task> getTasksByType(int id_type);
}
