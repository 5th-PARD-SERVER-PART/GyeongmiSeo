package com.pard.server.seminar4.card.entity;

import com.pard.server.seminar4.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String name;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void assignUser(User user){
        this.user = user;
        user.assignCard(this);
    }
}
