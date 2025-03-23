package com.pard.server.fifth.week3;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class RestMethodController {
    @GetMapping("")
    public String getUsers(){
        return "Get Method Controller";
    }


    @PostMapping("")
    public String postUser(){
        return "add user";
    }

    @GetMapping("/{userId}")
    public String getUser(@PathVariable Long userId){
        return "userId : "+ userId;
    }

    @PatchMapping("/{userId}")
    public String patchUser(@PathVariable Long userId){
        return "patch user Id : " + userId;
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable Long userId){
        return "Delete UserId : " + userId;
    }

}
