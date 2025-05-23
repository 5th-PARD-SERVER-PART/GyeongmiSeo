package com.pard.server.miruni.task.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class TaskReqDto {
    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TaskCreateReq {
        // 과제 이름
        private String task_name;

        // 질문 1~5
        private String q1;
        private String q2;
        private String q3;
        private String q4;
        private String q5;

        // 결론
        private String result;
    }
}
