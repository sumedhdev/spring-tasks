package com.sk.dao;

import com.sk.entity.Task;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("FakeData")
public class FakeDataTaskDao implements TaskDao {
    private static Map<Integer, Task> tasks;

    static {
        tasks = new HashMap<Integer, Task>();
        tasks.put(1, new Task(1, "Buy cabbage", false));
        tasks.put(2, new Task(2, "Walk the cat", true));
    }

    @Override
    public Collection<Task> getAllTasks(){
        return this.tasks.values();
    }

    @Override
    public Task getTaskById(int id){
        return this.tasks.get(id);
    }

    @Override
    public void addTask(int id, String description, boolean isCompleted){
        this.tasks.put(id, new Task(id, description, isCompleted));
    }

    @Override
    public void updateTask(Task task){
        this.tasks.put(task.getId(), task);
    }

    @Override
    public void deleteTaskById(int id){
        this.tasks.remove(id);
    }

}
