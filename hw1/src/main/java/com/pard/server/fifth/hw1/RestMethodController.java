package com.pard.server.fifth.hw1;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class RestMethodController {
    @GetMapping("")
    public String getUsers(){
        return "Get Method Controller.";
    }
    @GetMapping("/{name}")
    public String getUser(@PathVariable String name) {
        return "show " + name;
    }
    @PostMapping("/{name}")
    public String postUser(@PathVariable String name){
        return "add " + name;
    }

    @PatchMapping("/{name}")
    public String patchUser(@PathVariable String name){
        return "patch " + name;
    }

    @DeleteMapping("/{name}")
    public String deleteUser(@PathVariable String name){
        return "Delete " + name;
    }

}
