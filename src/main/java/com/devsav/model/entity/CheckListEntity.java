package com.devsav.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "check_list", schema = "public", catalog = "calendardb")
public class CheckListEntity {
    private int id;
    private String description;
    private boolean isComplete;
    private int idTask;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    @Column(name = "id_task")
    public int getIdTask() {
        return idTask;
    }

    public void setIdTask(int idTask) {
        this.idTask = idTask;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CheckListEntity that = (CheckListEntity) o;

        if (id != that.id) return false;
        if (isComplete != that.isComplete) return false;
        if (idTask != that.idTask) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (isComplete ? 1 : 0);
        result = 31 * result + idTask;
        return result;
    }
}