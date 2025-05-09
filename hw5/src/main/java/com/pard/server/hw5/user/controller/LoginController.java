package com.pard.server.hw5.user.controller;

import com.pard.server.hw5.post.dto.PostReadResDto;
import com.pard.server.hw5.post.service.PostService;
import com.pard.server.hw5.user.dto.UserResDto;
import com.pard.server.hw5.user.entity.User;
import com.pard.server.hw5.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;
    private final PostService postService;
    @GetMapping("/loginForm")
    public String login() {
        return "loginForm";
    }

    @GetMapping("/home")
    public String showMyPosts(@AuthenticationPrincipal OAuth2User oauthUser, Model model) {
        String email = (String) oauthUser.getAttribute("email");

        // System.out.println(email); -> 여기까진 문제 없는 거 확인

        UserResDto.ReadUser user = userService.findByEmail(email);  // DB에서 실제 User 꺼냄

//        System.out.println("----------> user id : "+user.getId() + "<--------"); -> 여기까지도 문제 없음

        List<PostReadResDto> posts = postService.findByUserId(user.getId());

        System.out.println("posts.size = " + posts.size());


        model.addAttribute("posts", posts);

        return "postOfUser"; // 템플릿에서 게시글 출력
    }



}


// http://localhost:8080/login/oauth2/code/google