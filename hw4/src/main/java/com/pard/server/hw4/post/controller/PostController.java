package com.pard.server.hw4.post.controller;


import com.pard.server.hw4.like.dto.LikeRequestDto;
import com.pard.server.hw4.like.service.LikeService;
import com.pard.server.hw4.post.dto.PostCreateReqDto;
import com.pard.server.hw4.post.dto.PostReadResDto;
import com.pard.server.hw4.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;
    private final LikeService likeService;
    @PostMapping("")
    public void createPost(@RequestParam Long userId, @RequestBody PostCreateReqDto req){
        postService.createPost(userId, req);
    }

    @GetMapping("")
    public List<PostReadResDto> readByUserId(@RequestParam Long userId){
        return postService.findByUserId(userId);
    }

    @GetMapping("/{postId}")
    public PostReadResDto getPost(@PathVariable Long postId) {
        return postService.getPostDetail(postId);
    }


    @PatchMapping("")
    public void update(@RequestParam Long postId, @RequestBody PostCreateReqDto postCreateReqDto){
        postService.update(postId, postCreateReqDto);
    }

    @DeleteMapping("")
    public void delete(@RequestParam Long postId){
        postService.delete(postId);
    }

    // like 눌렀을 때
    @PostMapping("/{postId}/like")
    public void likePost(@PathVariable Long postId, @RequestBody LikeRequestDto req) {
        likeService.likePost(postId, req.getUserId());
    }

}
