package com.newproject.model;



//Model class

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TodoList {

    @Id
    private Integer id;
    private String taskName;
    private Boolean status;

    public TodoList(){

    }

    public TodoList(String taskName, int id, Boolean status) {
        this.taskName = taskName;
        this.id = id;
        this.status = status;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
