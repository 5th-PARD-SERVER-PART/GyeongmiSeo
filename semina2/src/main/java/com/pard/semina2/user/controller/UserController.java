package com.pard.semina2.user.controller;


import com.pard.semina2.user.dto.UserDto;
import com.pard.semina2.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor // final 함수 생성자
@RequestMapping("/user")

public class UserController {
    private final UserService userService; // 변경하면 위험한 변수이므로 final로 선언
    @PostMapping("")
    public String save(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
        return "저장 완료 ~";
    }

    @GetMapping("/{studentId}")
    public UserDto findById(@PathVariable Long studentId) {
        return userService.findById(studentId);
    }

    @PatchMapping("/{studentId}")
    public String updatedById(@PathVariable Long studentId, @RequestBody UserDto userDto){
        userService.updateById(studentId, userDto);
        return "수정완료~";
    }

    @DeleteMapping("/{studentId}")
    public String delete(@PathVariable Long studentId) {
        userService.delete(studentId);
        return "삭제완료~";
    }

    @GetMapping("")
    public List<UserDto> findAll() {
        return userService.findAll();
    }
}
