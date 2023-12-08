package com.taskmanager.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class CreateTaskDTO {
    private String name;
    private String description;
    private Date dueDate;
}
