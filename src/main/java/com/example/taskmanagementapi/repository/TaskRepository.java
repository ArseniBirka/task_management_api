package com.example.taskmanagementapi.repository;

import com.example.taskmanagementapi.entity.Priority;
import com.example.taskmanagementapi.entity.Task;
import com.example.taskmanagementapi.entity.TaskStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Page<Task> findByStatus(TaskStatus status, Pageable pageable);
    Page<Task> findByPriority(Priority priority, Pageable pageable);
}