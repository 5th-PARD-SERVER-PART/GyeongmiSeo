package com.pard.server.seminar4.user.controller;

import com.pard.server.seminar4.user.dto.UserRequest;
import com.pard.server.seminar4.user.dto.UserResponse;
import com.pard.server.seminar4.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public UserResponse.ReadUser getUser(@PathVariable Long userId) {
        return userService.readUser(userId);
    }

    @PostMapping("")
    public void createUser(@RequestBody UserRequest.UserCreateRequest req) {
        userService.createUser(req);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }



}

