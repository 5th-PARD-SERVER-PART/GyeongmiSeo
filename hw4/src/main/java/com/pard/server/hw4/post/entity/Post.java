package com.pard.server.hw4.post.entity;

import com.pard.server.hw4.like.entity.Like;
import com.pard.server.hw4.post.dto.PostCreateReqDto;
import com.pard.server.hw4.post.dto.PostReadResDto;
import com.pard.server.hw4.user.entity.User;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@NoArgsConstructor @AllArgsConstructor
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
    private List<Like> likes = new ArrayList<>();


    public void updateContent(String newContent){
        this.content = newContent;
    }

    public static Post from(PostCreateReqDto req) {
        return new Post(null, req.getTitle(), req.getContent(), null, null);
    }

}
