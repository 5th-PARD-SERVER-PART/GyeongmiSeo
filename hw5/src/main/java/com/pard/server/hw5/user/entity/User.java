package com.pard.server.hw5.user.entity;

import com.pard.server.hw5.post.entity.Post;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING) // stirng 으로 설정 안 해놓으면 enum타입이 숫자로 들어간다. -> admin(0)
    @Builder.Default
    private Role role = Role.USER; // 기본 빌더는 user로 해달라는 말

    private String socialId; // 구글에서 할당해주는 사용자 고유의 아이디, 구글에서 관리해주는 pk같은 느낌. 변하지 않는 값

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Post> posts = new ArrayList<>();

}

