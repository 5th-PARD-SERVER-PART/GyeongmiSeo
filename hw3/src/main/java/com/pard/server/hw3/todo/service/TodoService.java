package com.pard.server.hw3.todo.service;


import com.pard.server.hw3.todo.dto.TodoDto;
import com.pard.server.hw3.todo.dto.UpdateTodoDto;
import com.pard.server.hw3.todo.entity.Todo;
import com.pard.server.hw3.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public void save(TodoDto todoDto){
        Todo todo = Todo.builder()
                .taskId(todoDto.getTaskId())
                .title(todoDto.getTitle())
                .priority(todoDto.getPriority())
                .type(todoDto.getType())
                .deadline(todoDto.getDeadline())
                .task(todoDto.getTask())
                .build();
        todoRepository.save(todo);
    }

    public String findById(Long taskId){
        Todo todo = todoRepository.findById(taskId).get();
        return todo.getTitle();
    }

    public List<TodoDto> getTodoDtos(String type){
        List<Todo> todos  = todoRepository.findByType(type);
        List<TodoDto> todoDtos = todos.stream().map(
                todo -> TodoDto.builder()
                        .taskId(todo.getTaskId())
                        .title(todo.getTitle())
                        .priority(todo.getPriority())
                        .type(todo.getType())
                        .deadline(todo.getDeadline())
                        .task(todo.getTask())
                        .build()).toList();
        return todoDtos;
    }

    public List<TodoDto> findAll() {
        List<Todo> todos = todoRepository.findAll();
        List<TodoDto> todoDtos = todos.stream().map(
                todo -> TodoDto.builder()
                        .taskId(todo.getTaskId())
                        .title(todo.getTitle())
                        .priority(todo.getPriority())
                        .type(todo.getType())
                        .deadline(todo.getDeadline())
                        .task(todo.getTask())
                        .build()).toList();
        return todoDtos;
    }

    public void updateById(Long taskId, UpdateTodoDto updateTodoDto){
        Todo todo = todoRepository.findById(taskId).orElseThrow(() -> new RuntimeException("해당 ID의 할 일이 존재하지 않습니다."));;
        todo.updateTitle(updateTodoDto.getTitle());
        todo.updatePriority(updateTodoDto.getPriority());
        todo.updateType(updateTodoDto.getType());
        todo.updateDeadline(updateTodoDto.getDeadline());
        todo.updateTask(updateTodoDto.getTask());
    }

    public void delete(Long taskId) {
        todoRepository.deleteById(taskId);
    }
}
