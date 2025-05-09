package com.pard.server.hw4.post.service;

import com.pard.server.hw4.post.dto.PostCreateReqDto;
import com.pard.server.hw4.post.dto.PostReadResDto;
import com.pard.server.hw4.post.entity.Post;
import com.pard.server.hw4.post.repository.PostRepo;
import com.pard.server.hw4.user.entity.User;
import com.pard.server.hw4.user.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final UserRepo userRepo;
    private final PostRepo postRepo;

    public void createPost(Long userId, PostCreateReqDto req){
//        Optional<User> u = userRepo.findById(userId);
        // 찾는 ID가 없으면 RuntimeException
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
//        User user = u.get();
        Post post = new Post(null, req.getTitle(), req.getContent(), user);
        postRepo.save(post);
    }

//    public PostReadResDto readPost(Long postId){
//        Post post = postRepo.findById(postId)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//        return new PostReadResDto(postId, post.getTitle(), post.getContent());
//    }

    public List<PostReadResDto> findByUserId(Long userId){
        List<Post> posts = postRepo.findAllByUserId(userId);

        List<PostReadResDto> postReadResDtos = posts.stream().map(
                post -> PostReadResDto.builder()
                        .id(post.getId())
                        .title(post.getTitle())
                        .content(post.getContent())
                        .build()).toList();

        return postReadResDtos;
    }

    @Transactional
    public void update(Long postId, PostCreateReqDto req){
        Post post = postRepo.findById(postId).get();
        post.updateContent(req.getContent());
        postRepo.save(post);
    }

    public void delete(Long postId){
        postRepo.deleteById(postId);
    }


}
