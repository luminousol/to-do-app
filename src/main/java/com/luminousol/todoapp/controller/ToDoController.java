package com.luminousol.todoapp.controller;

import com.luminousol.todoapp.dto.ToDoPatchDto;
import com.luminousol.todoapp.dto.ToDoPostDto;
import com.luminousol.todoapp.dto.ToDoResponseDto;
import com.luminousol.todoapp.entity.ToDo;
import com.luminousol.todoapp.mapper.ToDoMapper;
import com.luminousol.todoapp.service.ToDoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/")
@Validated
public class ToDoController {

    private final ToDoMapper mapper;
    private final ToDoService toDoService;

    public ToDoController(ToDoMapper mapper, ToDoService toDoService) {
        this.mapper = mapper;
        this.toDoService = toDoService;
    }

    @PostMapping
    public ResponseEntity postTodo(@RequestBody @Valid ToDoPostDto toDoAppPostDto) {

        ToDo toDo = toDoService.createToDo(mapper.toDoPostDtoToToDo(toDoAppPostDto));
//        ToDo response = toDoService.createToDo(toDo);
        ToDoResponseDto response = mapper.toDoToToDoResponseDto(toDo);

        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/{todo-id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity patchTodo(@PathVariable("todo-id") @Positive long todoId,
                                    @Valid @RequestBody ToDoPatchDto toDoPatchDto) {

        toDoPatchDto.setToDoId(todoId);

        ToDo toDo = toDoService.updateToDo(mapper.toDoPatchDtoToToDo(toDoPatchDto));
        ToDoResponseDto response = mapper.toDoToToDoResponseDto(toDo);

        return new ResponseEntity(response, HttpStatus.OK);
    }

    // todoId 로 하나만 불러 오기
    @GetMapping("/{todo-id}")
    public ResponseEntity getTodo(@PathVariable("todo-id") @Positive long todoId) {

        ToDo toDo = toDoService.readToDo(todoId);
        ToDoResponseDto response = mapper.toDoToToDoResponseDto(toDo);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 전체 조회
    @GetMapping
    public ResponseEntity getTodos() {

        List<ToDo> toDos = toDoService.readToDos();
        List<ToDoResponseDto> response = mapper.toDoToToDoResponseListDto(toDos);

        return new ResponseEntity(response, HttpStatus.OK);
    }

    // todoId 로 todo 하나만 지우기
    @DeleteMapping("/{todo-id}")
    public ResponseEntity deleteTodo(@PathVariable("todo-id") @Positive long todoId) {
        System.out.println("To Do 목록 삭제 하였습니다.");

        toDoService.deleteToDo(todoId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping()
    public ResponseEntity deleteTodos() {
        System.out.println("To Do 목록 전체 삭제하였습니다.");

        toDoService.deleteToDos();
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
