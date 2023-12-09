package com.taskmanager.Services.TaskService;

import com.taskmanager.Models.Task;
import com.taskmanager.Models.TaskStatus;
import com.taskmanager.dtos.CreateTaskDTO;
import com.taskmanager.dtos.UpdateTaskDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

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
    public Task findTaskById(Long id){
        Task foundTask= null;
        for (Task task: tasks) {
            if(task.getId().equals(id)){
                foundTask=task;
                break;
            }
        }
        if (foundTask==null){
            handleException(new Exception("Task not found"));
        }
        return foundTask;
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
        Task task= findTaskById(updateTaskDto.getId());
        if(task==null){
            return null;
        }
        if(updateTaskDto.getDescription()!=null){
            task.setTaskDescription(updateTaskDto.getDescription());
        }
        if(updateTaskDto.getDueDate()!=null){
            task.setDueDate(updateTaskDto.getDueDate());
        }
        return  task;
    }

    public boolean deleteTask(Long id){
       Task task=findTaskById(id);
       if(task!=null){
           tasks.remove(task);
           return true;
       }
        return false;
    }

    @ExceptionHandler(Exception.class)
    public void handleException(Exception e){
        throw new RuntimeException(e);
    }
    //TODO:- handle the errors in all the functions properly the null check and the http correct responses.
}
