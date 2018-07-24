package com.devsav.model.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Test {
    private Long id;
    private String event;
    private java.util.Date date;
    private Long id_user;
    private Long id_type;
    private Boolean is_complete;

    public Test() {
    }

    public Test (Long id, String event, java.util.Date date, Long id_user, Long id_type, Boolean is_complete) {
        this.id = id;
        this.event = event;
        this.date = date;
        this.id_user = id_user;
        this.id_type = id_type;
        this.is_complete = is_complete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public Long getId_type() {
        return id_type;
    }

    public void setId_type(Long id_type) {
        this.id_type = id_type;
    }

    public Boolean getIs_complete() {
        return is_complete;
    }

    public void setIs_complete(Boolean is_complete) {
        this.is_complete = is_complete;
    }
}
