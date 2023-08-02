package com.luminousol.todoapp.mapper;

import com.luminousol.todoapp.dto.ToDoPatchDto;
import com.luminousol.todoapp.dto.ToDoPostDto;
import com.luminousol.todoapp.dto.ToDoResponseDto;
import com.luminousol.todoapp.entity.ToDo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ToDoMapper {

    ToDo toDoPostDtoToToDo(ToDoPostDto toDoPostDto);
    ToDo toDoPatchDtoToToDo(ToDoPatchDto toDoPatchDto);
    ToDoResponseDto toDoToToDoResponseDto(ToDo toDo);

    List<ToDoResponseDto> toDoToToDoResponseListDto(List<ToDo> toDos);

}
