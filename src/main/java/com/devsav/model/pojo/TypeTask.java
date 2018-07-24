package com.devsav.model.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TypeTask {
  private Long id;
  private String type;
  private java.util.Date date_from;
  private java.util.Date date_to;

    public TypeTask() {
    }

    public TypeTask(Long id, String type, Date date_from, Date date_to) {
        this.id = id;
        this.type = type;
        this.date_from = date_from;
        this.date_to = date_to;
    }



    public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public java.util.Date getDate_from() {
    return date_from;
  }

  public void setDate_from(java.util.Date date_from) {
    this.date_from = date_from;
  }

  public java.util.Date getDate_to() {
    return date_to;
  }

  public void setDate_to(java.util.Date date_to) {
    this.date_to = date_to;
  }
}
