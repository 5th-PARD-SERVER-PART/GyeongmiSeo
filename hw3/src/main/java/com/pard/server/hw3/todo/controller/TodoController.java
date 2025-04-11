package com.pard.server.hw3.todo.controller;

import com.pard.server.hw3.todo.dto.TodoDto;
import com.pard.server.hw3.todo.dto.UpdateTodoDto;
import com.pard.server.hw3.todo.entity.Todo;
import com.pard.server.hw3.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoController {
    private final TodoService todoService;

    // 새로운 값 저장하기
    @PostMapping("")
    public String save(@RequestBody TodoDto todoDto) {
        todoService.save(todoDto);
        return "저장완료 ><";
    }

    // Id로 해당 투두 제목 찾기
    @GetMapping("/findTitle/{taskId}")
    public String findById(@PathVariable Long taskId) {
        return todoService.findById(taskId);
    }

    @GetMapping("/findType") // 어떤 종류인지를 받아서 해당 종류의 투두를 모두 반환
    public ResponseEntity<List<TodoDto>> findBytype(@RequestParam String type) {
        List<TodoDto> responseValue = todoService.getTodoDtos(type);
        return new ResponseEntity<>(responseValue, HttpStatus.OK);
    }

    // 모든 투두 가져와서 보여줘
    @GetMapping("")
    public List<TodoDto> findAll() {
        return todoService.findAll();
    }

    // URL로 받은 해당 Id 투두 내용 업데이트 하기.
    @PatchMapping("/{taskId}")
    public String updateById(@PathVariable Long taskId, @RequestBody UpdateTodoDto updateTodoDto) {
        todoService.updateById(taskId, updateTodoDto);
        return "수정 완료 ><";
    }

    @DeleteMapping("/{taskId}")
    public String delete(@PathVariable Long taskId) {
        todoService.delete(taskId);
        return "삭제완료 ><";
    }

}
