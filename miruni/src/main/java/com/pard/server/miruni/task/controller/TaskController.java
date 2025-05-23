package com.pard.server.miruni.task.controller;


import com.pard.server.miruni.task.dto.TaskReqDto;
import com.pard.server.miruni.task.dto.TaskResDto;
import com.pard.server.miruni.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    // 모든 Task 불러오기
    @GetMapping("")
    public List<TaskResDto.ReadUser> findAll(){
        return taskService.findAll();
    }

    @GetMapping("/{task_id}")
    public List<TaskResDto.ReadUser> findByPart(@PathVariable int task_id) {
        return taskService.findByTask_id(task_id);
    }

    @PostMapping("")
    public void save(@RequestBody TaskReqDto.TaskCreateReq req) {
        taskService.createUser(req);
    }

    @DeleteMapping("")
    public void delete(@RequestParam int task_id){
        taskService.delete(task_id);
    }

}
