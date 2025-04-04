package com.pard.server.fifth.hw2.todo.repository;

import com.pard.server.fifth.hw2.todo.dto.TodoDto;
import com.pard.server.fifth.hw2.todo.entity.Todo;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class TodoRepository {
    private static final Map<Long, Todo> memo = new HashMap<>();
    public void save(TodoDto todoDto) {
        Todo todo = Todo.builder()
                .taskId(todoDto.getTaskId())
                .priority(todoDto.getPriority())
                .deadline(todoDto.getDeadline())
                .task(todoDto.getTask())
                .build();
        memo.put(todoDto.getTaskId(),todo);
    }

    public TodoDto findById(Long taskId) {
        Todo todo = memo.get(taskId);

        return TodoDto.builder()
                .taskId(todo.getTaskId())
                .priority(todo.getPriority())
                .deadline(todo.getDeadline())
                .task(todo.getTask())
                .build();
    }

    public void updateById(Long taskId, TodoDto todoDto) {
        Todo todo = memo.get(taskId);

        todo.setTaskId(todoDto.getTaskId());
        todo.setPriority(todoDto.getPriority());
        todo.setDeadline(todoDto.getDeadline());
        todo.setTask(todoDto.getTask());
    }

    public void delete(Long taskId) {
        memo.remove(taskId);
    }

    public List<TodoDto> findAll() {
        return memo.values().stream() //memo의 value들을 stream,즉 컨베이어벨트 위에 올려서, todo값을 DTO로 변환(클래스 간 값을 주고 받을 때는 무조건 DTO로 변환해야 하기 때문에)
                .map(todo -> TodoDto.builder()
                        .taskId(todo.getTaskId())
                        .priority(todo.getPriority())
                        .deadline(todo.getDeadline())
                        .task(todo.getTask())
                        .build()).toList();
    }

}
