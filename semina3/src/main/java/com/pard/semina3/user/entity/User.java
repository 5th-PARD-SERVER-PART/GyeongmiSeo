package com.pard.semina3.user.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.sql.Timestamp;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 직접 ID를 지정하지 않아도 알아서 객체마다 아이디를 지정해줌. 자동으로. 순서대로(identity)
    private Long userId; // id type 은 long이 근본

    @Column(name = "email", length = 20) // Colume 어노테이션 안의 name
    private String email;

    @Column(name = "password")
    private String password;

    @CreationTimestamp
    private Timestamp userSignUpTime;

    // entity엔 setter를 직접 쓰는 것보단 우리가 직접 안전하게 만드는 것이 좋다.
    public void updateEmail(String email) {
        this.email = email;
    }
    public void updatePassword(String password) {
        this.password = password;
    }
}