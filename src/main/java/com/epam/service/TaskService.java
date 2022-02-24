package com.epam.service;

import com.epam.domain.Task;

import java.util.List;

public interface TaskService {

    List<Task> findAll();

    Task findByMessage(String message);

    void save(Task task);

    Task findById(Long id);



}
