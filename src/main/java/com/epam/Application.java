package com.epam;

import com.epam.service.impl.TaskServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.epam");
        TaskServiceImpl taskService = context.getBean(TaskServiceImpl.class);
        taskService.findAll().forEach(it -> System.out.println(it.getId()));
    }

}
