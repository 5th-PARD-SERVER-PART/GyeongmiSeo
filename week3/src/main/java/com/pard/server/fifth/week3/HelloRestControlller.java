package com.pard.server.fifth.week3;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestControlller {
    @RequestMapping("/helloRest")
    public String hello(){
        return "Hello Rest Server 5th";
    }
}
