package com.pard.server.hw4.like.service;

import com.pard.server.hw4.like.entity.Like;
import com.pard.server.hw4.like.repository.LikeRepo;
import com.pard.server.hw4.post.entity.Post;
import com.pard.server.hw4.post.repository.PostRepo;
import com.pard.server.hw4.user.entity.User;
import com.pard.server.hw4.user.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final UserRepo userRepo;
    private final PostRepo postRepo;
    private final LikeRepo likeRepo;

    public void likePost(Long postId, Long userId) {
        if (likeRepo.existsByUserIdAndPostId(userId, postId)) {
            throw new IllegalStateException("이미 좋아요를 눌렀습니다.");
        }

        User user = userRepo.findById(userId).orElseThrow();
        Post post = postRepo.findById(postId).orElseThrow();

        Like like = new Like(null, user, post);
        likeRepo.save(like);
    }
}

