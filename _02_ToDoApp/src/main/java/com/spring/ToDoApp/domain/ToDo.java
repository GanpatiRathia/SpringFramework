package com.spring.ToDoApp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Builder
public class ToDo {
	
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String todoItem;
  private String completed;
  
  public ToDo() {
      // No-argument constructor
  }

  // Constructor for creating a To-Do item without an ID.
  public ToDo(String todoItem, String completed) {
      this.todoItem = todoItem;
      this.completed = completed;
  }

  // Manually implement the builder pattern
  public static class ToDoBuilder {
      private Long id;
      private String todoItem;
      private String completed;

      public ToDoBuilder todoItem(String todoItem) {
          this.todoItem = todoItem;
          return this;
      }

      public ToDoBuilder completed(String completed) {
          this.completed = completed;
          return this;
      }

      public ToDo build() {
          ToDo todo = new ToDo();
          todo.setTodoItem(this.todoItem);
          todo.setCompleted(this.completed);
          return todo;
      }

  }
  
  public String getTodoItem() {
      return todoItem;
  }

  public void setTodoItem(String todoItem) {
      this.todoItem = todoItem;
  }

  public Long getId() {
      return id;
  }
  
  public void setId(Long id) {
      this.id = id;
  }
  
  public String getCompleted() {
      return completed;
  }

  public void setCompleted(String completed) {
      this.completed = completed;
  }

  public static ToDoBuilder builder() {
      return new ToDoBuilder();
  }
  
}