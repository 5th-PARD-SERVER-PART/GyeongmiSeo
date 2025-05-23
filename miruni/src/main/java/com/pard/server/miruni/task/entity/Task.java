package com.pard.server.miruni.task.entity;

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
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int task_id;

    // 과제 이름
    private String task_name;

    // 질문 1~6
    private String q1;
    private String q2;
    private String q3;
    private String q4;
    private String q5;

    // 키워드
    private String keyword;
}
