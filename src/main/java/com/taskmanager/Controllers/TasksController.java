package com.taskmanager.Controllers;

import com.taskmanager.Models.Task;
import com.taskmanager.Services.TaskService.TaskService;
import com.taskmanager.dtos.CreateTaskDTO;
import com.taskmanager.dtos.UpdateTaskDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TasksController {
    private final TaskService taskService;
    public TasksController(TaskService taskService){
        this.taskService=taskService;
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> tasks=taskService.getAllTask();
        return ResponseEntity.ok(tasks);
    }
    @PostMapping("/add-task")
    public ResponseEntity<Task> createTask(@RequestBody CreateTaskDTO createTaskDTO){
        Task task1=taskService.createTask(createTaskDTO);
        return ResponseEntity.ok(task1);
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") Long id){
        Task task=taskService.getTaskById(id);
        return ResponseEntity.ok(task);
    }
    @PatchMapping("/update-task")
    public ResponseEntity<Task> UpdateTask(@RequestBody UpdateTaskDto updateTaskDto){
        Task task=taskService.updateTask(updateTaskDto);
        return ResponseEntity.ok(task);
    }
    @DeleteMapping("/task/{id}")
    public ResponseEntity<Boolean> deleteTask(@PathVariable Long id){
        return ResponseEntity.ok(taskService.deleteTask(id));
    }
}
