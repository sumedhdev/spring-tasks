package com.sk.service;

import com.sk.dao.TaskDao;
import com.sk.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TaskService {

    @Autowired
    @Qualifier("MySQLData")
    private TaskDao dao;

    public Collection<Task> getAllTasks(){
        return this.dao.getAllTasks();
    }

    public Task getTaskById(int id){
        return this.dao.getTaskById(id);
    }

    public void addTask(String description, boolean isCompleted){
        this.dao.addTask(description, isCompleted);
    }

    public void updateTask(Task task){
        this.dao.updateTask(task);
    }

    public void deleteTaskById(int id){
        this.dao.deleteTaskById(id);
    }
}
