package com.devsav.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devsav.model.dao.TaskDAO;
import com.devsav.model.pojo.Task;
import com.devsav.service.interfaces.TaskService;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskDAO taskDAO;

    @Autowired
    public TaskServiceImpl(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskDAO.getAll();
    }

    @Override
    public boolean setCompleteTask(int id) {
        return taskDAO.setCompleteById(id);
    }

    @Override
    public List<Task> getTasksByType(int id_type) {
        return taskDAO.getTasksByType(id_type);
    }

}