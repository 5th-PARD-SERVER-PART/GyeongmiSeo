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

    @PostMapping("")
    public String save(@RequestBody TaskReqDto.TaskCreateReq req) {
        taskService.createUser(req);
        return "저장완료";
    }






}
