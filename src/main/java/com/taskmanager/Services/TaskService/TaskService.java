package com.taskmanager.Services.TaskService;

import com.taskmanager.Models.Task;
import com.taskmanager.Models.TaskStatus;
import com.taskmanager.dtos.CreateTaskDTO;
import com.taskmanager.dtos.UpdateTaskDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TaskService {
    List<Task> tasks=new ArrayList<>();
    Long id= 0L;

    public List<Task> getAllTask(){
        return tasks;
    }
    public  Task getTaskById(Long id){
        for (Task task: tasks) {
            if(task.getId().equals(id)){
                return task;
            }
        }
        return null;
    }
    public Task createTask(CreateTaskDTO createTaskDTO){
        Task task=new Task(id++,
                createTaskDTO.getName(),
                createTaskDTO.getDescription(),
                TaskStatus.PENDING,
                createTaskDTO.getDueDate());
        tasks.add(task);

        return task;
    }
    public Task updateTask(UpdateTaskDto updateTaskDto){
        Task task= (Task) tasks.stream().filter(task1 -> task1.getId().equals(updateTaskDto.getId()));
        if(updateTaskDto.getDescription()!=null){
            task.setTaskDescription(updateTaskDto.getDescription());
        }
        if(updateTaskDto.getDueDate()!=null){
            task.setDueDate(updateTaskDto.getDueDate());
        }
        return  task;
    }

    public String deleteTask(Long id){
        for (Task task: tasks) {
            if(task.getId().equals(id)){
                tasks.remove(task);
                return "Task Deleted";
            }
        }
        return "No such task with id "+Long.toString(id)+" found";
    }
}
