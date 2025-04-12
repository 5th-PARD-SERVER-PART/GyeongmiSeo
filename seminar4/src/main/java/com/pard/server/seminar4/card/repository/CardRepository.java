package com.pard.server.seminar4.card.repository;

import com.pard.server.seminar4.card.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {

}

