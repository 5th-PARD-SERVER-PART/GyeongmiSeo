package com.pard.server.miruni.task.service;

import com.pard.server.miruni.task.dto.TaskReqDto;
import com.pard.server.miruni.task.dto.TaskResDto;
import com.pard.server.miruni.task.entity.Task;
import com.pard.server.miruni.task.repository.TaskRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
                        .keyword(task.getKeyword())
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
                .keyword(req.getKeyword())
                .build();
        taskRepo.save(t);
    }

    public List<TaskResDto.ReadUser> findByTask_id(int task_id){
        List<Task> tasks  = taskRepo.findByTask_id(task_id);
        List<TaskResDto.ReadUser> dtos = tasks.stream().map(
                task -> TaskResDto.ReadUser.builder()
                        .task_id(task.getTask_id())
                        .task_name(task.getTask_name())
                        .q1(task.getQ1())
                        .q2(task.getQ2())
                        .q3(task.getQ3())
                        .q4(task.getQ4())
                        .q5(task.getQ5())
                        .keyword(task.getKeyword())
                        .build()).toList();
        return dtos;
    }

    public void delete(int task_id){
        Task user = taskRepo.findById(task_id).orElseThrow(IllegalAccessError::new);
        taskRepo.delete(user);
    }
}
