package com.pard.server.hw4.user.controller;

import com.pard.server.hw4.user.dto.*;
import com.pard.server.hw4.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/{userId}")
    public UserResDto.ReadUser getUser(@PathVariable Long userId) {
        return userService.readUser(userId);
    }

    @PostMapping("")
    public void createUser(@RequestBody UserReqDto.UserCreateReq req){
        // 이 body에선 post 값도 넘어오지만,
        // service 코드에서 post값을 null 로 설정하고 DTO로 넣게 됨.
        // null에서 post값 들어가게 바꿔보자
        userService.createUser(req);
    }


    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }
}
