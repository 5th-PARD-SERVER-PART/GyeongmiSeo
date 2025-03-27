# 컨트롤러라고? 너 누군데 ;;

## @RestController

~~@RestController는 Spring Framework에서 제공하는 어노테이션으로,
RESTful 웹 서비스를 만들기 위해 사용하는 클래스에 붙이는 어노테이션입니다.~~
라고 쓰고, 

**말 걸면 JSON 파일이나 텍스트로 대답해주는 칭긔** 라고 읽는다.

---

음 사실 **@Controller**라는 칭긔도 있긴 한데, 프론트에 더 적합한 칑긔라고 알고 있음.

이 칭긔 같은 경우엔 @RestController와 다르게 return값이 html 파일명이다.

다시 말해 같은 return "hello" 코드여도, 해당 클래스를

@Controller가 감싸고 있으면 "hello.html"파일을 return하고,

@RestController가 감싸고 있으면 "hello" 문자열을 return함.

---

걍 이것만 알아도 
음~ html은 프론트에서 주로 다루므로 나 김서버는 @Controller보단 정말 'real값'?들을 다루는 @RestController를 더 자주 쓰겠군~ 이라고 생각해 그냥


## @RequestMapping (요청 짝지어주기? 막이러시고)
Spring 애들한테 "야 이 URL 들어오면 이 메서드 실행시켜라" 이렇게 명령하는 주석.
![스크린샷 2025-03-28 오전 2 57 00](https://github.com/user-attachments/assets/d0c0a8f9-f6f6-4025-96ea-a4d482fdc050)

그냥 가만히 있다고 Controller가 알아주는게 아님. url 요청 오면 해당 url의 메서드가 이리와~ 하고 손짓하는게 @RequestMapping임.

---

MyRestController.java ⤵

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

늬들은 또 뭔데~~

---
- 🩷 PathVariable 🩷

  ***URL 경로 자체에 포함된 값***
  
  -> "고유한 리소스"를 가리키는 값(고유 ID, 사용자명, 글 번호 등등..에 사용)
  
    ```java
    @RequestMapping("/path2/{name}/{age}")
    public String path_2(@PathVariable("name") String name, @PathVariable("age") Integer age) {
        return "내 이름 " + name + ", 올해로 " + age + "살 입학했다.";
    }
    ```
    
    URL : [http://localhost:8080/path2/뭉치/1](http://localhost:8080/path2/뭉치/1)
  
     결과 화면 ⤵️
  
     <img width="648" alt="스크린샷 2025-03-28 오전 4 50 25" src="https://github.com/user-attachments/assets/cbd0017d-8fb4-46b5-b67d-08bc9e6e66e2" />


    
---

- 🩵 RequestParam 🩵

  ***URL 뒤에 붙는 ?name=형식***
  
  -> 부가적인 조건이나 옵션(검색, 정렬, 필터, 옵션 등등..에 사용)

    ```java
    @RequestMapping("/path2/{name}/{age}")
    public String path_2(@PathVariable("name") String name, @PathVariable("age") Integer age) {
        return "내 이름 " + name + ", 올해로 " + age + "살 입학했다.";
    }
    ```

    URL : [http://localhost:8080/param?name=뭉치&age=1](http://localhost:8080/param?name=뭉치&age=1)

    결과 화면 ⤵️

    <img width="570" alt="스크린샷 2025-03-28 오전 4 54 09" src="https://github.com/user-attachments/assets/9b2bb4d2-921b-46f1-b7e9-142dd11d7659" />

---
    
### 비유하자면?

치코파닭에서 주문 📞 : 
    
  - @PathVariable : "치킨 두 마리 주세요" -> 리소스를 정확히 지정
    
  - @RequestParam : "근데 맛은 치즈 머스타드와 마늘꿀로 주시고, 치즈떡 좀 많이 주세요" -> 부가적인 조건 추가
      
  
