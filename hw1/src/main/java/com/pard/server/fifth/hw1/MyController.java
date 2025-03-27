package com.pard.server.fifth.hw1;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class MyController {
    @RequestMapping("")
    public String hello(){
        return "안뇽띠 ~";
    }
    @RequestMapping("/gm/{id}")
    public String ID_and_TMI(@PathVariable String id,
                             @RequestParam(required = false) String TMI){
        if(TMI == null) {
            TMI = "TMI 적으라우";
        }
        return "유저 ID : "+id+", TMI : "+TMI;
    }
}
