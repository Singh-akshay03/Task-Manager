package com.taskmanager.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class UpdateTaskDto {
    private Long id;
    private String description;
    private Date dueDate;
}
