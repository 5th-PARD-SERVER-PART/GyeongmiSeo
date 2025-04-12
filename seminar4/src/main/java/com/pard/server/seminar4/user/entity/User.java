package com.pard.server.seminar4.user.entity;

import com.pard.server.seminar4.book.entity.Book;
import com.pard.server.seminar4.card.entity.Card;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> book;

    @OneToOne(mappedBy = "user")
    private Card card;

    public void assignCard(Card card) {
        this.card = card;
    }
}
