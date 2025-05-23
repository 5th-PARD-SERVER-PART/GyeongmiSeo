package com.pard.server.hw4.like.controller;

import com.pard.server.hw4.like.dto.LikeRequestDto;
import com.pard.server.hw4.like.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/likes")
public class LikeController {

    private final LikeService likeService;

    // 👍 좋아요 등록
    @PostMapping("/post/{postId}")
    public void likePost(@PathVariable Long postId,
                         @RequestBody LikeRequestDto req) {
        likeService.likePost(postId, req.getUserId());
    }

    // 👎 좋아요 취소 (선택)
    @DeleteMapping("/post/{postId}")
    public void unlikePost(@PathVariable Long postId,
                           @RequestBody LikeRequestDto req) {
        likeService.unlikePost(postId, req.getUserId());
    }
}

