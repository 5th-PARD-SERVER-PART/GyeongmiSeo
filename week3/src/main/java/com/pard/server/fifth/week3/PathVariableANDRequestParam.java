package com.pard.server.fifth.week3;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathVariableANDRequestParam {
    @RequestMapping("/km/{id}")
    public String PVandRP(@PathVariable String id, @RequestParam(required = false) String detail)
    {
        return "유저 ID : " + id + ", Retail : " + detail;
    }
}
