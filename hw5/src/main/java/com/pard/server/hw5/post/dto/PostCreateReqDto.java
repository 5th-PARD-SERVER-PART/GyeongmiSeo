package com.pard.server.hw5.post.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostCreateReqDto {
    private String title;
    private String content;
}

