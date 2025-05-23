package com.pard.server.hw4.like.repository;

import com.pard.server.hw4.like.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepo extends JpaRepository<Like, Long> {
    Optional<Like> findByUser_IdAndPost_Id(Long userId, Long postId);

    boolean existsByUserIdAndPostId(Long userId, Long postId);
}

