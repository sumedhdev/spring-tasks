package com.sk.dao;

import com.sk.entity.Task;

import java.util.Collection;

/**
 * Created by main on 26/04/17.
 */
public interface TaskDao {
    Collection<Task> getAllTasks();

    Task getTaskById(int id);

    void addTask(String description, boolean isCompleted);

    void updateTask(Task task);

    void deleteTaskById(int id);
}
