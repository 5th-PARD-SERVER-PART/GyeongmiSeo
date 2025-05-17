package com.pard.server.seminar6.controller;


import com.pard.server.seminar6.dto.UserReqDto;
import com.pard.server.seminar6.dto.UserResDto;
import com.pard.server.seminar6.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    // 모든 사람 가져와
    @GetMapping("")
    public List<UserResDto.ReadUser> findAll() {
        return userService.findAll();
    }

    @GetMapping ("/{part}")
    public List<UserResDto.ReadUser> findByPart(@PathVariable String part) {
        return userService.findByPart(part);
    }
    @GetMapping("/{userId}")
    public UserResDto.ReadUser getUser(@PathVariable int userId) {
        return userService.readUser(userId);
    }

    @PostMapping("")
    public String save(@RequestBody UserReqDto.UserCreateReq req) {
        userService.createUser(req);
        return "저장완료";
    }

    @PatchMapping("/{userId}")
    public void updateById(@PathVariable int userId, @RequestBody UserReqDto.UserUpdateReq userUpdateReq) {
        userService.updateById(userId, userUpdateReq);
    }

    @DeleteMapping("")
    public void delete(@RequestParam int userId){
        userService.delete(userId);
    }
}
