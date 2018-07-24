package com.devsav.model.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Task {
  private Long id;
  private String event;
  private Date date;
  private String is_complete;
  private Long id_people;
  private Long id_type;

  public Task() {
  }

  public Task(Long id, String event, Date date, String is_complete, Long id_people, Long id_type) {
    this.id = id;
    this.event = event;
    this.date = date;
    this.is_complete = is_complete;
    this.id_people = id_people;
    this.id_type = id_type;
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

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getIs_complete() {
    return is_complete;
  }

  public void setIs_complete(String is_complete) {
    this.is_complete = is_complete;
  }

  public Long getId_people() {
    return id_people;
  }

  public void setId_people(Long id_people) {
    this.id_people = id_people;
  }

  public Long getId_type() {
    return id_type;
  }

  public void setId_type(Long id_type) {
    this.id_type = id_type;
  }
}
