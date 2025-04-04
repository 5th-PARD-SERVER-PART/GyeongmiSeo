package com.pard.server.fifth.hw2.todo.service;


import com.pard.server.fifth.hw2.todo.dto.TodoDto;
import com.pard.server.fifth.hw2.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // final 클래스 생성자
public class TodoService {
    private final TodoRepository todoRepository; // 이것또한 바뀌면 위험하므로 final로 선언

    public void saveTodo (TodoDto todoDto) {
        todoRepository.save(todoDto);
    }

    public TodoDto findById(Long taskId) {
        return todoRepository.findById(taskId);
    }

    public void updateById(Long taskId, TodoDto todoDto) {
        todoRepository.updateById(taskId, todoDto);
    }

    public void delete(Long taskId) { todoRepository.delete(taskId); }

    public List<TodoDto> findAll() {
        return todoRepository.findAll();
    }
}
