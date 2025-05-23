package com.pard.server.miruni.task.dto;

import com.pard.server.miruni.task.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class TaskResDto {
    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReadUser{
        private int task_id;

        // 과제 이름
        private String task_name;

        // 질문 1~4
        private String q1;
        private String q2;
        private String q3;
        private String q4;

        // 키워드
        private String keyword;

        public static TaskResDto.ReadUser from(Task task) { // 유저 정보 들어오면 builder로 정보 감싸서 DTO 형식으로 만듬
            return ReadUser.builder()
                    .task_id(task.getTask_id())
                    .task_name(task.getTask_name())
                    .q1(task.getQ1())
                    .q2(task.getQ2())
                    .q3(task.getQ3())
                    .q4(task.getQ4())
                    .keyword(task.getKeyword())
                    .build();
        }
    }
}
