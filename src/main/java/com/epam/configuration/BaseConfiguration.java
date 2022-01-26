package com.epam.configuration;

import com.epam.repository.TaskRepository;
import com.epam.service.impl.TaskServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseConfiguration {

    @Bean
    public TaskServiceImpl getTaskServiceImpl(TaskRepository taskRepository) {
        return new TaskServiceImpl(taskRepository);
    }

}
