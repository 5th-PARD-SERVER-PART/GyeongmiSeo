package com.pard.server.fifth.hw1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathVariableController {

    @RequestMapping("/path1/{name}")
    public String path_1(@PathVariable("name") String name) {
        return "---> " + name + " <--- path page";
    }

    @RequestMapping("/path2/{name}/{age}")
    public String path_2(@PathVariable("name") String name, @PathVariable("age") Integer age) {
        return "내 이름 " + name + ", 올해로 " + age + "살 입학했다.";
    }


}
