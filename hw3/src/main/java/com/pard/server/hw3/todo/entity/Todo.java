package com.pard.server.hw3.todo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = )
    private Long taskId;

    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "priority")
    private Long priority; // 우선순위

    @Column(name = "type")
    private String type; // 종류(ex. 공부, 만남 등..)

    @Column(name = "deadline")
    private String deadline; // 마감일

    @Column(name = "task")
    private String task; // 해야 하는 일 내용

    public void updateTitle(String title) {
        this.title = title;
    }
    public void updatePriority(Long priority){
        this.priority = priority;
    }
    public void updateType(String type){
        this.type = type;
    }
    public void updateDeadline(String deadline){
        this.deadline = deadline;
    }

    public void updateTask(String task) {
        this.task = task;
    }
}
