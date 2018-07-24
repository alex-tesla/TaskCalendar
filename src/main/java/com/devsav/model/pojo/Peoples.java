package com.devsav.model.pojo;


import javax.xml.bind.annotation.*;
import java.util.LinkedList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Peoples {

    public Peoples() {
    }


    private List<People> peoples = new LinkedList<>();

    public void setPeoples(List<People> peoples) {
        this.peoples = peoples;
    }

    public List<People> getPeoples() {
       return peoples;
    }
}
