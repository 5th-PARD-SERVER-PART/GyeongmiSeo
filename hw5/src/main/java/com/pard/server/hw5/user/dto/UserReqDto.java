package com.pard.server.hw5.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pard.server.hw5.post.dto.PostCreateReqDto;
import com.pard.server.hw5.user.entity.Role;
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
        private String name;
        private String email;
        private List<PostCreateReqDto> posts;
    }
}
