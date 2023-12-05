package com.taskmanager.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
public class Task {
    private Long Id;
    private String taskName;
    private String taskDescription;
    private TaskStatus taskStatus;
    private Date dueDate;
}
