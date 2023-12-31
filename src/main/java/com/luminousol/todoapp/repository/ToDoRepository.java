package com.luminousol.todoapp.repository;

import com.luminousol.todoapp.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}
