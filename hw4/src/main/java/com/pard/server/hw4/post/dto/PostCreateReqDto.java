package com.pard.server.hw4.post.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostCreateReqDto {
    private String title;
    private String content;
    // 좋아요 추가
    private Long like;
}

