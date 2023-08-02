package com.luminousol.todoapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ToDoResponseDto {
    private long toDoId;

    private String toDoTitle;

    private int toDoOrder;

    private boolean toDoCompleted;
}