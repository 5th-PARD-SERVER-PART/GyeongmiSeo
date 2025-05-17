package com.pard.server.seminar6.dto;

import com.pard.server.seminar6.entity.User;
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
        private int id;
        private String name;
        private int age;
        private String part;
//        private List<PostResDto.PostReadResponse> posts;

        public static UserResDto.ReadUser from(User user) { // 유저 정보 들어오면 builder로 정보 감싸서 DTO 형식으로 만듬
            return UserResDto.ReadUser.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .age(user.getAge())
                    .part(user.getPart())
                    .build();
        }
    }

}
