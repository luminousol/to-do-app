package com.luminousol.todoapp.service;

import com.luminousol.todoapp.dto.ToDoResponseDto;
import com.luminousol.todoapp.entity.ToDo;
import com.luminousol.todoapp.repository.ToDoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public ToDo createToDo(ToDo toDo){

        ToDo createdToDo = toDoRepository.save(toDo);

        return createdToDo;
    }

    public ToDo updateToDo(ToDo toDo) {
        ToDo readToDo = readVerifiedToDo(toDo.getToDoId());

        Optional.ofNullable(toDo.getToDoTitle())
                .ifPresent(title -> readToDo.setToDoTitle(title));
        Optional.ofNullable(toDo.getToDoOrder())
                .ifPresent(order -> readToDo.setToDoOrder(order));
        Optional.ofNullable(toDo.isToDoCompleted())
                .ifPresent(completed -> readToDo.setToDoCompleted(completed));

        ToDo updatedToDo = toDoRepository.save(readToDo);

        return updatedToDo;
    }

    public ToDo readToDo(long todoId) {
        return readVerifiedToDo(todoId);
    }

    private ToDo readVerifiedToDo(long toDoId) {
        Optional<ToDo> optionalToDo =
                toDoRepository.findById(toDoId);
        ToDo response
                = optionalToDo.orElseThrow(() -> new RuntimeException("ToDo not found with id: " + toDoId));
        return response;
    }
    public List<ToDo> readToDos() {
        List<ToDo> toDos = toDoRepository.findAll();

        return toDos;
    }

    public void deleteToDo(long toDoId) {
        ToDo readToDo = readVerifiedToDo(toDoId);
        toDoRepository.delete(readToDo);
    }

    public void deleteToDos() {
        toDoRepository.deleteAll();
    }

}
