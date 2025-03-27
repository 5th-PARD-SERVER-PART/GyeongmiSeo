package com.pard.server.fifth.hw1;

import org.springframework.web.bind.annotation.*;

@RestController
public class MyRestController {

    @RequestMapping("")
    public String hello(){
        return "안뇽 ~";
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
