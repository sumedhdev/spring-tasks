package com.sk.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Represents a task. A task has a description and is either completed or not completed.
 */
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String description;

    private boolean isCompleted;

    public Task(){

    }

    public Task(String description, boolean isCompleted){
        this.description = description;
        this.isCompleted = isCompleted;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription(){
        return this.description;
    }

    public boolean getIsCompleted() {
        return this.isCompleted;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIsCompleted(boolean isCompleted){
        this.isCompleted = isCompleted;
    }
}
