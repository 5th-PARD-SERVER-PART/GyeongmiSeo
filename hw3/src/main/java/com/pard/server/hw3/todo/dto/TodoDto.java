package com.pard.server.hw3.todo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoDto {
    private Long taskId;
    private String title;
    private Long priority; // 우선순위
    private String type; // 종류(ex. 공부, 만남 등..)
    private String deadline; // 마감일
    private String task; // 해야 하는 일 내용
}
