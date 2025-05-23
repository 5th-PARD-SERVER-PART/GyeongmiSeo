package com.pard.server.hw4.post.dto;

import com.pard.server.hw4.like.entity.Like;
import com.pard.server.hw4.post.entity.Post;
import com.pard.server.hw4.user.dto.UserResDto;
import com.pard.server.hw4.user.entity.User;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostReadResDto {
    private Long id;
    private String title;
    private String content;
    private List<Like> likeUsers;


    public static List<PostReadResDto> postToDto(List<Post> posts){
        List<PostReadResDto> ret = new ArrayList<>();
        for(Post post : posts){
            PostReadResDto p = new PostReadResDto(post.getId(), post.getTitle(), post.getContent(), post.getLikes());
            ret.add(p);
        }
        return ret;
    }

    @Getter @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserDto {
        private Long id;
        private String name;

        public static UserDto from(User user) {
            return UserDto.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .build();
        }
    }

    public static PostReadResDto from(Post post) {
        List<UserDto> likeUserDtos = post.getLikes().stream()
                .map(like -> UserDto.from(like.getUser()))
                .collect(Collectors.toList());

        return PostReadResDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .likeUsers(post.getLikes())
                .build();
    }

}
