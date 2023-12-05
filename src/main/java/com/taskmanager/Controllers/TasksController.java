package com.taskmanager.Controllers;

import com.taskmanager.Models.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class TasksController {

    List<Task> tasks=new ArrayList<>();

    @GetMapping("/tasks")
    public List<Task> getAllTasks(){
        return  tasks;
    }
    @PostMapping("/add-task")
    public Task createTask(@RequestBody Task task){
        tasks.add(task);
        return task;
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable("id") Long id){
        Task foundTask= (Task) tasks.stream().filter(task -> task.getId().equals(id));
//        if(foundTask==null){
//
//        }
        return foundTask;
    }
}
