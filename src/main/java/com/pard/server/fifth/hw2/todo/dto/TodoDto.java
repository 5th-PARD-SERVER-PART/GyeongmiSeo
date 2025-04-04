package com.pard.server.fifth.hw2.todo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor //  받을 수 있게 만들어 주는 기본 생성자
@Builder
public class TodoDto {
    private Long taskId; // todo 마다 고유한 아이디
    private Long priority; // 우선순위
    private String deadline; // 마감일
    private String task; // 해야 하는 일 내용
}
