package com.devsav.model.pojo;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;

@XmlRootElement(name = "type_task")
public class TypeTasks {
    public TypeTasks() {
    }
    @XmlElement(name = "type")
    private List<TypeTask> types = new LinkedList<>();

    public void setTypes(List<TypeTask> types) {
        this.types = types;
    }

}
