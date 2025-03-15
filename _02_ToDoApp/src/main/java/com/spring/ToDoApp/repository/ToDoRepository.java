package com.spring.ToDoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spring.ToDoApp.domain.ToDo;

/**
 * Repository for managing To-Do entities.
 * Extends JpaRepository to provide CRUD operations.
 */
@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}
