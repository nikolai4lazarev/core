package com.epam.repository;

import com.epam.domain.Task;

import java.util.List;

public interface TaskRepository {

    List<Task> findAll();

}
