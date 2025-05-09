package com.pard.server.seminar5.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/loginForm")
    public String login() {
        return "loginForm";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }


}
