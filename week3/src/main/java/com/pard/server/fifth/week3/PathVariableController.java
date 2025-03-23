package com.pard.server.fifth.week3;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathVariableController {
    @RequestMapping("/path/{name}")
    public String path(@PathVariable("name") String myName){
        return "1st path var controller name : " + myName;
    }

    @RequestMapping("/pathV2/{userName}")
    public String path2(@PathVariable String userName){
        return "2nd path var controller name : " + userName;
    }

    @RequestMapping("/pathV3/{name}/{age}")
    public String path3(@PathVariable String name, @PathVariable Long age){
        return "3rd user name : " + name + " age : " + age;
    }
}
