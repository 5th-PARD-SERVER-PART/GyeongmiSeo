package com.pard.server.fifth.week3;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

@RestController
public class RequestParamController {
    @RequestMapping("/v1")
    public String param1(@RequestParam("name") String myName, @RequestParam("age") int myAge){
        return "RequestParam 1번 : " + myName + " 나이 " + myAge;
    }

    @RequestMapping("/v2")
    public String param2(@RequestParam String name, @RequestParam int age){
        return "RequestParam 2번 : "+name + " 나이 "+ age;
    }

    @RequestMapping("/v3")
    public String param3(String name, int age){
        return "RequestParam 3번 : " + name + " 나이 " + age;
    }

    // 입력값이 비었을 때 에러 핸들링
    @RequestMapping("/v4")
    public String param4(@RequestParam String name,@RequestParam(required = false) Integer age){
        if (age == null) {
            return "Request param 4 : " + name + " age : Not provided";
        }
        return "Request param 4 : " + name + " age : " + age;
    }

    @RequestMapping("/v5")
    public String param5(
            @RequestParam(required = true,defaultValue = "파드") String name,@RequestParam(required = false, defaultValue = "-1") Integer age){
        return "RequestParam 5번 : " + name + " 나이 "+ age;
    }

    // 밑의 v6에서는 입력값을 Map으로 설정해서 한 번에 처리하도록 하는데,
    // 사실 데이터 다루긴 쉬워도 입력이 어떻게 될지는 모르기 때문에 에러를 다루기 힘들다.
    // 거의 쓰지 않는 방법
    @RequestMapping("/v6")
    public String param6(@RequestParam Map<String, Objects> map){
        return "RequestParam 6번 : "+ map.get("name") + map.get("age");
    }
}