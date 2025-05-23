package com.pard.server.hw4.like.repository;

import com.pard.server.hw4.like.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepo extends JpaRepository<Like, Long> {
    boolean existsByUserIdAndPostId(Long userId, Long postId);
}

