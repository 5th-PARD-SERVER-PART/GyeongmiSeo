package com.pard.semina3.user.controller;

import com.pard.semina3.user.dto.UserDto;
import com.pard.semina3.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("")
    public void save(@RequestBody UserDto userDto){
        userService.save(userDto);
    }

    @GetMapping("/userId")
    public UserDto readById(@PathVariable Long userId) {
        return userService.read(userId);
    }

    @GetMapping("/userNum") // 사용자의 email을 받아서 해당 사용자의 id를 반환하는 햄
    public ResponseEntity<Long> readByEmail(@RequestParam String email) {
        Long responseValue = userService.getUserNum(email); // 해당 email로 사용자를 찾아서 id를 반환. responseValue = id값
        return new ResponseEntity<>(responseValue, HttpStatus.OK);
        // ResponseEntity<> 는, HTTP 응답을 직접 커스터마이징해서 보낼 수 있게 해주는, Spring에서 제공하는 함수이다.
        //
        // 클라이언트에게 전달할 진짜 데이터 (responseValue)
        // HTTP 상태 코드 (HttpStatus.OK = 200 OK)
    }

    @GetMapping("")
    public List<UserDto> readAll() {
        return userService.readAll();
    }

    @PatchMapping("/{userId}")
    public void update(@PathVariable Long userId, @RequestBody UserDto userDto){
        userService.update(userId, userDto);
    }

}
