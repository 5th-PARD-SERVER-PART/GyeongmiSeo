package com.pard.server.hw4.post.controller;


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
    private  final PostService postService;
    @PostMapping("")
    public void createPost(@RequestParam Long userId, @RequestBody PostCreateReqDto req){
        postService.createPost(userId, req);
    }

    @GetMapping("")
    public List<PostReadResDto> readByUserId(@RequestParam Long userId){
        return postService.findByUserId(userId);
    }

    @PatchMapping("")
    public void update(@RequestParam Long postId, @RequestBody PostCreateReqDto postCreateReqDto){
        postService.update(postId, postCreateReqDto);
    }

    @DeleteMapping("")
    public void delete(@RequestParam Long postId){
        postService.delete(postId);
    }
}
