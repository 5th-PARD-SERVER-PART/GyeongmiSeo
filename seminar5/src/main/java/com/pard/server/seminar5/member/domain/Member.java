package com.pard.server.seminar5.member.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING) // stirng 으로 설정 안 해놓으면 enum타입이 숫자로 들어간다. -> admin(0)
    @Builder.Default
    private  Role role = Role.USER; // 기본 빌더는 user로 해달라는 말

    private String socialId; // 구글에서 할당해주는 사용자 고유의 아이디, 구글에서 관리해주는 pk같은 느낌. 변하지 않는 값


}
