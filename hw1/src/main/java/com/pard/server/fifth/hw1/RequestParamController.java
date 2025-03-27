package com.pard.server.fifth.hw1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestParamController {
    @RequestMapping("/param")
    public String param1(@RequestParam("name") String name, @RequestParam("age") Integer age){
        return "< " + name + "(" + age + ")" + " >" + " '파람 받고 따블로 가' ";
    }

    @RequestMapping("/param2")
    public String param2(@RequestParam String name, @RequestParam Integer age){
        return "< " + name + "(" + age + ")" + " >" + " '파람 받고 따블로 가' ";
    }

    @RequestMapping("/param3")
    public String param3(@RequestParam(required = true, defaultValue = "한동이") String name,
                         @RequestParam(required = false, defaultValue = "0") Integer age){
        return name + ", " + age + "살 !";
    }
}
