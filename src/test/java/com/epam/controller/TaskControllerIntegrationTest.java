package com.epam.controller;

import com.epam.domain.Task;
import com.epam.repository.JpaTaskRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@ActiveProfiles("integration-test")
class TaskControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private JpaTaskRepository taskRepository;
    private static final String BASE_PATH = "/task";

    @Test
    @SneakyThrows
    void test() {
        // GIVEN
        Task task = new Task();
        task.setMessage("Hello");
        Task savedTask = taskRepository.save(task);


        // WHEN
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.get(BASE_PATH + "/" + savedTask.getId())
        );

        // THEN
        String response = resultActions
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();
        Task actual = objectMapper.readValue(response, Task.class);

        assertThat(actual).isEqualTo(savedTask);
    }

    @Test
    @SneakyThrows
    void createNewTask_shouldResponse_http200() {
        // GIVEN
        Task task = new Task();
        task.setMessage("Hello");
        ObjectMapper objectMapper = new ObjectMapper();

        // WHEN
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.post(BASE_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(task))
        );

        // THEN
        resultActions
                .andExpect(MockMvcResultMatchers.status().isOk());

        List<Task> tasks = taskRepository.findAll();
        assertThat(tasks.isEmpty()).isFalse();

    }

}