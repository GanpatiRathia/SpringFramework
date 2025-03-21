package com.spring.ToDoApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.spring.ToDoApp.domain.ToDo;
import com.spring.ToDoApp.repository.ToDoRepository;
import java.util.Optional;

/**
 * Controller for managing To-Do items.
 * Provides endpoints for listing, adding, updating, and deleting tasks.
 */
@Controller
public class ToDoController {

    @Autowired
    private ToDoRepository todoRepository;

    /**
     * Root URL mapping (redirects to index page).
     */
    @GetMapping("/")
    public String todoList(Model model, @RequestParam(name = "showCompleted", defaultValue = "false") boolean showCompleted) {
        model.addAttribute("todos", todoRepository.findAll());
        model.addAttribute("showCompleted", showCompleted);
        return "todo";
    }

    /**
     * Adds a new To-Do item.
     */
    @PostMapping("/todoNew")
    public String add(@RequestParam String todoItem, @RequestParam String status, Model model) {
        ToDo todo = new ToDo(todoItem, status);
        todoRepository.save(todo);
        return "redirect:/";
    }

    /**
     * Deletes a To-Do item by ID.
     */
    @PostMapping("/todoDelete/{id}")
    public String delete(@PathVariable long id) {
        todoRepository.deleteById(id);
        return "redirect:/";
    }

    /**
     * Updates the completion status of a To-Do item.
     */
    @PostMapping("/todoUpdate/{id}")
    public String update(@PathVariable long id) {
        Optional<ToDo> optionalTodo = todoRepository.findById(id);
        if (optionalTodo.isPresent()) {
            ToDo todo = optionalTodo.get();
            todo.setCompleted(todo.getCompleted().equals("Yes") ? "No" : "Yes");
            todoRepository.save(todo);
        }
        return "redirect:/";
    }

    @GetMapping("/showCompleted")
    public String showCompleted(Model model){
        return "redirect:/?showCompleted=true";
    }
}