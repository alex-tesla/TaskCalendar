package com.devsav.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.devsav.model.pojo.Task;
import com.devsav.service.interfaces.TaskService;

import java.util.List;

@Controller
public class TaskController {
    private static final Logger LOGGER = Logger.getLogger(TaskController.class);

    private TaskService taskService;

    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }


    @RequestMapping(value = "/calendar/all", method = RequestMethod.GET)
    public ModelAndView showAllTask() {
        List<Task> listOfTask = taskService.getAllTasks();
        return new ModelAndView("task_all", "listOfTask", listOfTask);
    }

    @RequestMapping(value = "/calendar/home", method = RequestMethod.GET)
    public ModelAndView showHomeTask() {
        List<Task> listOfTask = taskService.getTasksByType(1);
        return new ModelAndView("task_home", "listOfTask", listOfTask);
    }

    @RequestMapping(value = "/calendar/family", method = RequestMethod.GET)
    public ModelAndView showFamilyTask() {
        List<Task> listOfTask = taskService.getTasksByType(2);
        return new ModelAndView("task_family", "listOfTask", listOfTask);
    }

    @RequestMapping(value = "/calendar/work", method = RequestMethod.GET)
    public ModelAndView showWorkTask() {
        List<Task> listOfTask = taskService.getTasksByType(3);
        return new ModelAndView("task_work", "listOfTask", listOfTask);
    }

    @RequestMapping(value = "/calendar/other", method = RequestMethod.GET)
    public ModelAndView showOtherTask() {
        List<Task> listOfTask = taskService.getTasksByType(4);
        return new ModelAndView("task_other", "listOfTask", listOfTask);
    }

    @RequestMapping(value = "/calendar/complete", method = RequestMethod.POST)
    public String setCompleteTask(@RequestParam int id, String url) {
        if (taskService.setCompleteTask(id)) {
            return "redirect:" + url;
        }
        return "error";
    }
}