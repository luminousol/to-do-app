package com.luminousol.todoapp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

// post 하는데 데이터 전달
@Getter
@Setter
public class ToDoPostDto {

    @NotBlank
    private String title;

    private int toDoOrder;

    private boolean completed;
}
