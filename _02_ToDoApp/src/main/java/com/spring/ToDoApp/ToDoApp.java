package com.spring.ToDoApp;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.spring.ToDoApp.domain.ToDo;
import com.spring.ToDoApp.repository.ToDoRepository;

/**
 * Main class for the Spring Boot To-Do application.
 * This class initializes the application and populates some initial data.
 */
@SpringBootApplication
public class ToDoApp implements CommandLineRunner {

    @Autowired
    private ToDoRepository todoRepository;

    public static void main(String[] args) {
        SpringApplication.run(ToDoApp.class, args);
    }

    /**
     * This method runs after the application starts and adds some initial tasks.
     */
    @Override
    public void run(String... args) throws Exception {
        // Creating a test ToDo item using Builder
        ToDo test = ToDo.builder()
                .todoItem("Python ML")
                .completed("Yes")
                .build();

        System.out.println(test);

        // List of initial ToDo items
        List<ToDo> todos = Arrays.asList(
                new ToDo("Learn Spring", "Yes"),
                new ToDo("Learn Driving", "No"),
                new ToDo("Go for a Walk", "No"),
                new ToDo("Cook Dinner", "Yes")
        );

        // Saving all ToDo items in the repository
        todoRepository.saveAll(todos);
    }
}
