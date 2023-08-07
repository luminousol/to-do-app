package com.luminousol.todoapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ToDoResponseDto {
    private long id;

    private String title;

    private int toDoOrder;

    private boolean completed;
}