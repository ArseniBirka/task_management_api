package com.example.taskmanagementapi.dto;

import com.example.taskmanagementapi.entity.Priority;
import com.example.taskmanagementapi.entity.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskRequest {

    @NotBlank(message = "Title must not be blank")
    private String title;

    private String description;

    @NotNull(message = "Status must not be null")
    private TaskStatus status;

    @NotNull(message = "Priority must not be null")
    private Priority priority;
}