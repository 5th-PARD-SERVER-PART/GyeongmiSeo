package com.pard.server.fifth.hw2.todo.controller;


import com.pard.server.fifth.hw2.todo.dto.TodoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.pard.server.fifth.hw2.todo.service.TodoService;
import java.util.List;

@RestController
@RequiredArgsConstructor // final 함수 생성자
@RequestMapping("/todo")

public class TodoController {
    private final TodoService todoService; // 변경하면 위험한 변수이므로 final로 선언
    @PostMapping("")
    public String save(@RequestBody TodoDto todoDto) {
        todoService.saveTodo(todoDto);
        return "저장 완료 ~";
    }

    @GetMapping("/{taskId}")
    public TodoDto findById(@PathVariable Long taskId) {
        return todoService.findById(taskId);
    }

    @PatchMapping("/{taskId}")
    public String updatedById(@PathVariable Long taskId, @RequestBody TodoDto todoDto){
        todoService.updateById(taskId, todoDto);
        return "수정완료~";
    }

    @DeleteMapping("/{taskId}")
    public String delete(@PathVariable Long taskId) {
        todoService.delete(taskId);
        return "삭제완료~";
    }

    @GetMapping("")
    public List<TodoDto> findAll() {
        return todoService.findAll();
    }
}
