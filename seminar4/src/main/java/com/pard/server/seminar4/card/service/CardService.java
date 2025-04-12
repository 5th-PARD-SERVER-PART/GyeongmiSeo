package com.pard.server.seminar4.card.service;

import com.pard.server.seminar4.card.dto.CardRequest;
import com.pard.server.seminar4.card.entity.Card;
import com.pard.server.seminar4.card.repository.CardRepository;
import com.pard.server.seminar4.user.entity.User;
import com.pard.server.seminar4.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepo;
    private final UserRepository userRepo;

    public void createCard(CardRequest.CardCreateRequest req) {
        Optional<User> u = userRepo.findById(req.getUserId());
        User user = u.get();

        Card card = Card.builder()
                .id(null)
                .name(req.getName())
                .user(user)
                .build();

        card.assignUser(user);
        cardRepo.save(card);
        userRepo.save(user);
    }


}

