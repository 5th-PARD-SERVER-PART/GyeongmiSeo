package com.pard.server.hw4.post.repository;

import com.pard.server.hw4.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {
    List<Post> findAllByUserId(Long id);
}

