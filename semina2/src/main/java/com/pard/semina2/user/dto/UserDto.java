package com.pard.semina2.user.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor //  받을 수 있게 만들어 주는 기본 생성자
@Builder
public class UserDto {
    private Long studentId;
    private String studentName;
}
