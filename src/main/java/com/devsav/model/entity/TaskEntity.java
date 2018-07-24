package com.devsav.model.entity;

import javax.persistence.*;
//import java.sql.Date;
import java.util.Date;


@Entity
@Table(name = "task", schema = "public", catalog = "calendardb")
public class TaskEntity {
    private int id;
    private String event;
    private Date date;
    private boolean isComplete;
    private int idPeople;
    private int idType;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "event")
    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "is_complete")
    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    @Basic
    @Column(name = "id_people")
    public int getIdPeople() {
        return idPeople;
    }

    public void setIdPeople(int idPeople) {
        this.idPeople = idPeople;
    }

    @Basic
    @Column(name = "id_type")
    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskEntity that = (TaskEntity) o;

        if (id != that.id) return false;
        if (isComplete != that.isComplete) return false;
        if (idPeople != that.idPeople) return false;
        if (idType != that.idType) return false;
        if (event != null ? !event.equals(that.event) : that.event != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (event != null ? event.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (isComplete ? 1 : 0);
        result = 31 * result + idPeople;
        result = 31 * result + idType;
        return result;
    }
}