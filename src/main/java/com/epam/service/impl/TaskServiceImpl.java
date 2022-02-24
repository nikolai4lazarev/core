package com.epam.service.impl;

import com.epam.domain.Task;
import com.epam.repository.JpaTaskRepository;
import com.epam.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final JpaTaskRepository repository;
    private String helloMessage;

    @Override
    public List<Task> findAll() {
        return repository.findAll();
    }

    @Override
    public Task findByMessage(String message) {
        return repository.findByMessage(message);
    }

    @Override
    public void save(Task task) {
        repository.save(task);
    }

    @Override
    public Task findById(Long id) {
        return repository.findById(id).get();
    }

}
