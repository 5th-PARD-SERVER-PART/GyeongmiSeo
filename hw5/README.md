# private final Hw hw;

마지막 과제인만큼 리드미도 조금은 정성껏 어쩌면 성의껏 작성해보겠습니다

---

먼저 사용자 인증 방식에는 크게 session과 token이 있죠

# Session vs Token

사용자의 인증 정보를 어느쪽(client/server)에서 저장하고 관리하는지에 따른 차이

## - session
   1. user가 login을 하면, server가 사용자의 인증 상태를 server의 메모리나 DB에 저장함.
   2. 그 후 server는 client에게 session id 라는 것을 발급해주고,
   3. 그 session id로 해당 사용자의 인증상태를 확인하게 된다.
   4. 즉, session은 user의 인증상태를 server에 저장하고 관리하는 것이다.


## - token (ex.JWT)
  1. user가 login을 하면, server는 user 정보를 암호화 한 token을 생성하게 된다
  2. 생성된 token을 client에게 전달해준다.
  3. client는 이 token을 local strorage나 쿠키에 저장하게 됨.
  4. 이후 client는 server에게 request(요청)을 보낼 때마다 token을 http의 header(URL에 담는 것이 아닌 보다 안전한 방식)에 담아 서버로 보낸다.
  5. server는 그 token의 유효성만 검증한다. 별도의 인증상태를 저장하진 않는다는 소리. (stateless)
  6. 인증 상태는 브라우저(client)가 저장한다. 



    jwt token은 총 3가지로 나뉜다. Header, Payload, Signature
    

참고 : session 방식은 사실 서버가 인증 상태를 기억해야 해서, 서버가 여러 대일 때 세션들은 서로 동기화가 필요하다. 이 말은 즉 서버 확장성에 불리하다는 뜻이다.
고전적인? 방식이긴하나 그렇다고 해서 합리적인 방법은 아닌듯.

token 방식은 서버가 직접 인증 상태를 저장하지 않기 때문에, 서버가 몇 대든 상관없이 토큰의 유효성만 검증하면 된다고 한다 -> 확장성에 유리

---

위에까지가 session과 token의 차이이다. 

처음 이해하기 시작할 때는 token 방식과 같이 브라우저가 다 들고 다니면 오히려 보안에 취약하지 않나 오히려 더 의문이 들었는데,

이런 보안 문제를 해결하기 위해 (유효기간 짧은)access token과 (유효기간 상대적으로 긴)refresh token을 함께 사용한다고 한다.

# Access Token과 Refresh Token은 짝꿍띠

1. Access Token만 쓰면 개털됨

    Access Token은 서버가 별도의 상태를 저장하지 않고, 토큰 자체로 인증 정보를 저장하는 방식인데, 

    만약 Access Token이 노출되면, 만료되기 전까진 누구나 해당 user인 척 서버한테 사기칠 수 있다는 거다 ㄷㄷ. 개망함

    이 위험을 줄이기 위해 Access Token의 유효기간을 짧게(예: 1시간) 설정한다. 짧은 시간 안에 탈취된 토큰이 악용될 가능성을 줄이는 것.

2. user님이 사용할 때 불편하시면 안 되니깐~

    Access Token만 짧은 유효기간으로 사용하면, user는 자주 로그인을 반복해야 하므로 ux 불편함ㅠ

    Refresh Token은 유효기간이 길고(예: 2주), 서버가 별도로 저장하고 관리해줌.

    Access Token이 만료되면, 사용자는 Refresh Token을 이용해 별도의 로그인 과정 없이 새로운 Access Token을 발급받을 수 있삼

더 자세한 내용은 이 딱 봐도 읽기 싫게 생긴 퍼플렉시티의 답변을 참고하자.

<img width="700" alt="스크린샷 2025-05-10 오전 2 17 25" src="https://github.com/user-attachments/assets/2d1e5290-9825-407d-8f59-77dd22da4a7b" />


ㅋㅋㅋ이런 방식도 그렇고 jwt처럼 signature 암호화도 그렇고 세상엔 참 똑똑한 사람들이 많은 것 같다
암튼 이 정도로 하고 일단 과제 코드로 넘어가즈아~~

---

이번 hw5는 session 방식 사용함. db 연결. 해줘야 하겠지

워크벤치에서 db 생성 -> 인텔리제이에서 db 연결(user는 root로 설정하고, 비번 입력해서 Test Connectrion -> Apply -> 저장?)
그리고 야멜 파일에서 디비 이름이랑 비번 설정해준다음에 

- __꼭!!! gitignore에 *.yaml 추가해주고 깃허브에 gitognore만 먼저 push 해주기.__ 

매번 강조하지만 매번 잊고 세상에 내 DB 비번 보여주는 나.

그리고 yaml파일에 또 추가할 것이 있다. 구글 클라우 페이지에서 프로젝트 이러쿵저러쿵 생성하면(세미나5 pdf참고) client id랑 pw 포함해서 또 추가해야 할 것이 있는데

음. 서버 노션 세미나5 페이지를 참고하자

코드로 들어가즈아~

이번 과제는 hw4에서 로그인 기능을 추가하는 건데,

이 과정에서 한 Controller 패키지 아래 두개의 Controller가 존재하고(User 도메인 안에),
한 Service 패키지 아래 두 개의 Service 파일이 존재해버렸다. 이게 맞나 해서 알아보니, 실무에서도 이렇게 쓰인단다.

그치만 두 개의 역할은 극명하다.

## Controller

<img width="700" alt="스크린샷 2025-05-10 오전 2 21 11" src="https://github.com/user-attachments/assets/58494590-4fa5-41d8-8542-8e2f051cf784" />

중간 주석 2개는 중간에 html로 값이 잘 안 넘어가길래 email이랑 id는 넘어가고 있는지 확인하기 위해서 있는 거라 무시해도 된다.
지우지 않은 이유는 git push로 귀엽지도 않은 개큰이슈가 여러번 있었어서 이제는 remote와 local 서로 변경사항이 생기는 것에 대해 병적으로 예민해져있는 상태이다.
이번에 많이 배웠다~ 하하

<img width="300" alt="스크린샷 2025-05-10 오전 2 30 20" src="https://github.com/user-attachments/assets/02a4ff2d-496d-4fcc-97ac-555202d88dc9" />


- LoginController 
  - hw4까지와는 다르게, client에게 요청이 들어오면 바로 controller를 보지 않고,
    
  - config(설정파일, 그 중에서도 가장 중요한 SecurityConfig파일)먼저 보면, 클래스 안에 FilterChain이라는 메서드가 보인다. 이 메서드는 Spring Sequrity가 client로부터 받은 요청에 응답하기 전, 필터링을 먼저 거치는데, 이 SecurityConfig로 어떻게 필터링 할 지 정한다.

      <img width="700" alt="스크린샷 2025-05-10 오전 2 32 31" src="https://github.com/user-attachments/assets/bdd58870-813f-4073-8272-47ccdd6f5c39" />

    갑자기 얘 왜 들고 왔냐? 바로 이 config 파일에서 로긘 성공 시 어느 Controller의 요청으로 갈 지 정해주기 때문이다.

    바로 이 코드에서
    
    <img width="600" alt="스크린샷 2025-05-10 오전 2 36 31" src="https://github.com/user-attachments/assets/702f7e7a-432f-4642-a9d5-0e13bffff4f8" />

    따라서 LoginController는 우리가 이전까지 구현해왔던 JSON 방식의 data구조를 주거니 받거니 하는 것과는 다르다.

    사용자가 login 성공 시, (SecurityConfig 파일에서 구현된 내용에 따라) /hom으로 GetMapping된 showMyPosts가 실행되는데,

    이 메서드는 로그인 성공 한 oauthUser를 받아 해당 user의 email로 id를 찾고, 그 id로 그 user가 작성한 post들을 DTO형식으로 받아 
    로그인 성공 시 띄워지는 postOfUser.html에 그 값과 함께 띄워진다.

    일단 내가 구글로 로그인을 하면, DB엔 이렇게 내 정보가 저장이 된다.
    
    <img width="500" alt="스크린샷 2025-05-10 오전 2 46 43" src="https://github.com/user-attachments/assets/43824bcb-1d0c-4bf4-b57f-afdfdf64bb8a" />

    로그인 후 post를 여러개 작성해놓고,
    
    <img width="500" alt="스크린샷 2025-05-10 오전 2 49 05" src="https://github.com/user-attachments/assets/02452e4e-e9b7-4333-8d2a-b5c07f6f2dd7" />

    다시 로그인을 하면 내가 쓴 post들이 이렇게 뜨게 된다.
    
    <img width="500" alt="스크린샷 2025-05-10 오전 2 50 15" src="https://github.com/user-attachments/assets/c3fb37a1-81c6-4d98-a356-bd2fe1ad03e5" />

    사실 이게 다임
   (다른 컨트롤러는 지금까지 우리가 했던 거)

## Service

service도 마찬가지로 UserService는 지금까지 우리가 해오던 방식이고, 

로그인 기능이 추가되면서 새롭게 추가된 방식의 Pricipal..Service는 구글 로그인 후 받아온 유저 정보로 회원가입 or 로그인 처리하는 커스터마이징 된 썰빌씨스이다.

<img width="700" alt="스크린샷 2025-05-10 오전 2 58 24" src="https://github.com/user-attachments/assets/71aa5a5c-3368-446d-ba4a-f0328934aed8" />

log.info() : @Slf4j이 지원하는 Logger객체의 출력 메서드인데, 똑같은 출력 메서드 println과 다른 점은, 좀 더 log 정보를 세세하게 지원해준다는 점. 어노테이션 이름이 신기하게 생겼다.

걍 이 서비스 클래스 요약하자면 

1. 구글 로그인 되면 user 정보 받아옴
2. DB에 그 이메일로 가입된 user 있나 확인
3. 없으면 새로 가입, 있으면 pass~



오늘도 리드미 늦어서 죄숨다..항상 후회합니다..프로후회러입니다 저는


그리고 전 자러가겠습니다. 20000!

<img width="200" alt="스크린샷 2025-05-10 오전 3 08 22" src="https://github.com/user-attachments/assets/193f49d7-03de-4dc5-bfbe-515787d5a57a" />




