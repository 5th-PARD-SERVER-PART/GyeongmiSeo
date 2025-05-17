package com.pard.server.seminar6.entity;

import com.pard.server.seminar6.dto.UserReqDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String name;


    private int age;


    private String part;

    public void updateUser(String name, int age, String part){
        this.name = name;
        this.age = age;
        this.part = part;
    }
}
