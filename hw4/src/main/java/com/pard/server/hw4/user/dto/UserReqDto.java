package com.pard.server.hw4.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pard.server.hw4.post.dto.PostCreateReqDto;
import com.pard.server.hw4.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class UserReqDto {
    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserCreateReq {
        // 유저 생성 시 이 DTO 형식으로 user create 하게 됨.
        // id는 DB에서 자동 생성 되고,
        // data 받을 때는 name이랑 posts만 받으면 된다.
        private String name;
        private List<PostCreateReqDto> posts;
    }
}
