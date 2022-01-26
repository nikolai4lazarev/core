package com.epam.service.impl;

import com.epam.domain.Task;
import com.epam.repository.TaskRepository;
import com.epam.service.TaskService;

import java.util.List;

public class TaskServiceImpl implements TaskService {

    private TaskRepository repository;

    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Task> findAll() {
        return repository.findAll();
    }

}
