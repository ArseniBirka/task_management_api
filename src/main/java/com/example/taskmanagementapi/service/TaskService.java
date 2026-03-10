package com.example.taskmanagementapi.service;

import com.example.taskmanagementapi.dto.TaskRequest;
import com.example.taskmanagementapi.entity.Priority;
import com.example.taskmanagementapi.entity.Task;
import com.example.taskmanagementapi.entity.TaskStatus;
import com.example.taskmanagementapi.exception.TaskNotFoundException;
import com.example.taskmanagementapi.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private static final Logger logger = LoggerFactory.getLogger(TaskService.class);

    private final TaskRepository taskRepository;

    public Task createTask(TaskRequest request) {
        logger.info("Creating new task with title: {}", request.getTitle());

        Task task = Task.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .status(request.getStatus())
                .priority(request.getPriority())
                .createdAt(LocalDateTime.now())
                .build();

        return taskRepository.save(task);
    }

    public Page<Task> getAllTasks(Pageable pageable) {
        logger.info("Fetching all tasks. Page: {}, Size: {}",
                pageable.getPageNumber(), pageable.getPageSize());

        return taskRepository.findAll(pageable);
    }

    public Task getTaskById(Long id) {
        logger.info("Searching task with id: {}", id);

        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    public Task updateTask(Long id, TaskRequest request) {
        logger.info("Updating task with id: {}", id);

        Task task = getTaskById(id);
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setStatus(request.getStatus());
        task.setPriority(request.getPriority());

        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        logger.info("Deleting task with id: {}", id);

        Task task = getTaskById(id);
        taskRepository.delete(task);
    }

    public Page<Task> getTasksByStatus(TaskStatus status, Pageable pageable) {
        logger.info("Fetching tasks by status: {}", status);

        return taskRepository.findByStatus(status, pageable);
    }

    public Page<Task> getTasksByPriority(Priority priority, Pageable pageable) {
        logger.info("Fetching tasks by priority: {}", priority);

        return taskRepository.findByPriority(priority, pageable);
    }

    public List<Task> searchTasks(String title) {
        logger.info("Searching tasks by title: {}", title);

        return taskRepository.findByTitleContainingIgnoreCase(title);
    }
}