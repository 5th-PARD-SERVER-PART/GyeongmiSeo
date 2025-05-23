package com.pard.server.hw4.post.entity;

import com.pard.server.hw4.user.entity.User;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor @AllArgsConstructor
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    // 좋아요 기능 추가
    private Long like; // 해당 Post의 좋아요 수

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void updateContent(String newContent){
        this.content = newContent;
    }
}
