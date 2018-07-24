package com.devsav.model.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CheckList {
  private Long id;
  private Long id_task;
  private String description;
  private Boolean is_complete;

    public CheckList() {
    }

    public CheckList(Long id, Long id_task, String description, Boolean is_complete) {
        this.id = id;
        this.id_task = id_task;
        this.description = description;
        this.is_complete = is_complete;
    }

    public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId_task() {
    return id_task;
  }

  public void setId_task(Long id_task) {
    this.id_task = id_task;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Boolean getIs_complete() {
    return is_complete;
  }

  public void setIs_complete(Boolean is_complete) {
    this.is_complete = is_complete;
  }
}
