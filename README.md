# 컨트롤러라고? 너 누군데 ;;

## @RestController

~~@RestController는 Spring Framework에서 제공하는 어노테이션으로,
RESTful 웹 서비스를 만들기 위해 사용하는 클래스에 붙이는 어노테이션입니다.~~
라고 쓰고, 

**말 걸면 JSON이나 텍스트로 대답해주는 칭긔** 라고 읽는다.
![스크린샷 2025-03-28 오전 2 57 00](https://github.com/user-attachments/assets/d0c0a8f9-f6f6-4025-96ea-a4d482fdc050)


## @RequestMapping
Spring 애들한테 "야 이 URL 들어오면 이 메서드 실행시켜라" 이렇게 명령하는 주석.
그냥 가만히 있다고 Controller가 알아주는게 아님. url 요청 오면 해당 url의 메서드가 이리와~ 하고 손짓하는게 @RequestMapping임.

⬇️ MyRestController.java ⬇️

```java
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
```

## @PathVariable vs @RequestParam
