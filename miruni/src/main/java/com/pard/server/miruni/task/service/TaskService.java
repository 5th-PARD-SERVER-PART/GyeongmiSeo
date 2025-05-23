package com.pard.server.miruni.task.service;

import com.pard.server.miruni.task.dto.TaskReqDto;
import com.pard.server.miruni.task.dto.TaskResDto;
import com.pard.server.miruni.task.entity.Task;
import com.pard.server.miruni.task.repository.TaskRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepo taskRepo;

    public List<TaskResDto.ReadUser> findAll() {
        List<Task> tasks = taskRepo.findAll();
        List<TaskResDto.ReadUser> dtos = tasks.stream().map(
                task -> TaskResDto.ReadUser.builder()
                        .task_id(task.getTask_id())
                        .task_name(task.getTask_name())
                        .q1(task.getQ1())
                        .q2(task.getQ2())
                        .q3(task.getQ3())
                        .q4(task.getQ4())
                        .q5(task.getQ5())
                        .result(task.getResult())
                        .build()).toList();
        return dtos;
    }

    public void createUser(TaskReqDto.TaskCreateReq req){
        Task t = Task.builder()
                .task_name(req.getTask_name())
                .q1(req.getQ1())
                .q2(req.getQ2())
                .q3(req.getQ3())
                .q4(req.getQ4())
                .q5(req.getQ5())
                .result(req.getResult())
                .build();
        taskRepo.save(t);
    }

}
