package com.epam.repository;

import com.epam.domain.Task;
import com.epam.service.TaskService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

    private TaskService service;

    @Override
    public List<Task> findAll() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setPassword("postgres");
        driverManagerDataSource.setUsername("postgres");
        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/lab");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(driverManagerDataSource);
        return jdbcTemplate.query("SELECT * FROM tasks", (rs, rowNum) -> {
            Task task = new Task();
            task.setId(rs.getLong("id"));
            task.setMessage(rs.getString("message"));
            return task;
        });
    }
}
