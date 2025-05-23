package com.pard.server.hw4.post.dto;

import com.pard.server.hw4.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostReadResDto {
    private Long id;
    private String title;
    private String content;
    // 좋아요
    private Long like;

    public static List<PostReadResDto> postToDto(List<Post> posts){
        List<PostReadResDto> ret = new ArrayList<>();
        for(Post post : posts){
            PostReadResDto p = new PostReadResDto(post.getId(), post.getTitle(), post.getContent(), post.getLike());
            ret.add(p);
        }
        return ret;
    }

}
