package com.epam.repository;

import com.epam.domain.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepositoryImpl implements TaskRepository {
    @Override
    public List<Task> findAll() {
        return List.of(new Task(1L), new Task(2L));
    }
}
