package com.sk.entity;

/**
 * Represents a task. A task has a description and is either completed or not completed.
 */
public class Task {

    private int id;

    private String description;

    private boolean isCompleted;

    public Task(){

    }

    public Task(int id, String description, boolean isCompleted){
        this.id = id;
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
