package com.sk.controller;

import com.sk.entity.Task;
import com.sk.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Task> getAllTasks(){
        return this.service.getAllTasks();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Task getTaskById(@PathVariable("id") int id){
        return this.service.getTaskById(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addTask(@RequestBody Task newTask){
        this.service.addTask(newTask.getDescription(), newTask.getIsCompleted());
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateTask(@RequestBody Task task){
        this.service.updateTask(task);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTaskById(@PathVariable("id") int id){
        this.service.deleteTaskById(id);
    }

}
