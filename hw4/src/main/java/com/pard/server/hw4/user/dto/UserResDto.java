package com.pard.server.hw4.user.dto;

import com.pard.server.hw4.user.entity.User;
import com.pard.server.hw4.post.dto.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserResDto {

    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReadUser{
        private Long id;
        private String name;
//        private List<PostResDto.PostReadResponse> posts;

        public static UserResDto.ReadUser from(User user) {
            return UserResDto.ReadUser.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .build();
        }
    }
}
