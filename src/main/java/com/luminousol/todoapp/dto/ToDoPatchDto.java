package com.luminousol.todoapp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

// Patch 하는데 데이터 전달
@Getter
@Setter
public class ToDoPatchDto {

    private long toDoId;    // patch 는 todoId가 필요

    @NotBlank
    private String toDoTitle;

    private int toDoOrder;

    private boolean toDoCompleted;
}
