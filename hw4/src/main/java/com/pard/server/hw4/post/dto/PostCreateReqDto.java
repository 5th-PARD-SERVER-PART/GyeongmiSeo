package com.pard.server.hw4.post.dto;

import com.pard.server.hw4.like.entity.Like;
import com.pard.server.hw4.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostCreateReqDto {
    private String title;
    private String content;

}

