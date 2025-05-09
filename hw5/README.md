# 마지막 과제

먼저 깃 푸쉬 이슈에 도움을 주신 나임언니에게 감사를 표하며..

일단 마지막 과제인만큼 리드미도 성의껏 작성해보겠습니다

숏커톤이 다가오는 만큼 이제 미리미리 시작해보겠다 다짐을 하여...무려 목요일...시작했습니다...

본론으로 바로 들어가보도록 하겠슴미다

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

더 자세한 내용은 이 읽기 싫은 사진을 참고하자.
![스크린샷 2025-05-10 오전 1.56.54.png](..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2Frd%2Fsxnhkcyd7178p87cjyrhgx200000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_zlK5uC%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202025-05-10%20%EC%98%A4%EC%A0%84%201.56.54.png)

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

이 과정에서 한 Controller 패키지 아래 두개의 Controller가 존재하고,
한 Service 패키지 아래 두 개의 Service 파일이 존재해버렸다. 이게 맞나 해서 알아보니, 실무에서도 이렇게 쓰인단다.

그치만 두 개의 역할은 극명하다.

## Controller 먼저 보자.

- LoginController 
  - hw4까지와는 다르게, client에게 요청이 들어오면 바로 controller를 보지 않고, 
  - config(설정파일, 그 중에서도 가장 중요한 SecurityConfig파일)먼저 보면, 클래스 안에 