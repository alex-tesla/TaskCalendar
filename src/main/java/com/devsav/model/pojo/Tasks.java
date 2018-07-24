package com.devsav.model.pojo;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;

@XmlRootElement(name = "tasks")
public class Tasks {
    public Tasks() {
    }
    @XmlElement(name = "task")
    private List<Task> tasks = new LinkedList<>();

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
