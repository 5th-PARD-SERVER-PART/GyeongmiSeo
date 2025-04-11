spring과의 권태기 극복. 빵빠레 불면서 극복.
지난 며칠간 과제 입덕 부정기를 겪다 결국 과제 마감일 금요일에 코드를 뜯어보면서 흥미를 get!
열 발자국 멀어졌던 spring과 한 발 짝 가까워지기.

욕심 같아서는 코드 전체의 흐름을 타며 리뷰하고 싶지만...

내 게으름 자아의 비대함 이슈로 처음 코드 뜯어보면서 이해가 필요했던 부분과 왠지 모를 촉으로 이건 까먹기 전에 적어 놓아야겠다싶은 것들 위주로 요약해보려고 한다. 

처음 Project initialize할 때 추가할 dependency도 까먹은 나에게 큰 감동을 받았다.

그래서 일단 이번 리드미는 프로젝트 초기화 단계부터 적어보려고 한다.

# 0. Spring Initialize
프로젝트 이름과 패기지 설정 후, dependency를 추가하게 될 것이다. 지금까진 아래 4개의 dependency를 추가하여 프로젝트를 생성한다.

<img width="600" alt="스크린샷 2025-04-12 오전 1 03 08" src="https://github.com/user-attachments/assets/5ca251eb-9acc-45fd-8b08-9e7944f8b85c" />

우리가 이번 과제에서부턴 DB를 연결하게 되면서, 특히나 주목해야 할 dependency 두 가지가 있다.

1. Spring Data JPA
    : JPA는 자바 객체를 데이터베이스에 매핑하여 객체 중심으로 데이터를 관리할 수 있게 해주는 *ORM 기술.
   
      *ORM 기술 : OOP 언어의 객체와 관계형 데이터베이스의 테이블을 매핑하여, SQL 없이도 객체 단위로 DB를 다룰 수 있게 해주는 기술이다.

                 DB와의 상호작용을 객체 중심으로 추상화해 개발 생산성을 높이고, 코드의 재사용성과 유지보수성을 향상시킨다.

  JPA 선배님은 그저 빛...
  
3. MySQL Driver
   : Spring Boot 같은 프레임워크에서 MySQL 데이터베이스와 연동하기 위해 필요한 라이브러리를 자동으로 프로젝트에 추가해줌


아무쪼록 이렇게 의존성 주입을 끝내주고 프로젝트를 생성해주면 된다.

자 여기서 끝이 아니다. 일단 우리가 해줄 것이 있다.

바로, yaml파일 만들고. ./gitignore 파일 수정 후 ./gitignore 먼저 커밋 때려주기.

<img width="353" alt="스크린샷 2025-04-12 오전 1 11 20" src="https://github.com/user-attachments/assets/0677297b-f895-416a-b37c-be43620f9397" />

yaml파일은 이 위치에 있어야 한다. 아마 원래 이 위치에는 확장자가 properties로 되어있는 파일이 먼저 상주해있을테지만 어림도 없지.

우린 DB 연결해야 하니까 yaml로 확장자를 먼저 변경준다. 

그리고 아래 코드로 내용을 채워준다. 여기서 프로젝트 이름, 디비 이름, 님 비번(db비번)을 변경해주어야 한다.

```
spring:
  application:
    name: 프로젝트 이름 

  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/디비이름?serverTimezone=UTC&characterEncoding=UTF-8
    username: root
    password: 님 비번

  web:
    cors:
      allowed-origins: http://localhost:3000

  jpa:
    show-sql: true
    database-platform: org.hibernate.dialect.MySQL8Dialect
    database: mysql
    hibernate:
      ddl-auto: update
    generate-ddl: false
    properties:
      hibernate:
        format_sql: true
        enable_lazy_load_no_trans: true
```

그리고 중요한 단계!!!

./gitignore 파일에 이 yaml 파일을 추가해주어야 한다.

<img width="200" alt="스크린샷 2025-04-12 오전 1 16 10" src="https://github.com/user-attachments/assets/4459dc45-f230-4e2c-8388-36acc648ac7f" />

요로코롬.
왜??왜 깃이그노어에 야멜을 꼭 추가해주어야 하냐고???

<img width="400" alt="스크린샷 2025-04-12 오전 1 52 19" src="https://github.com/user-attachments/assets/2d78ce4b-3c22-4ebf-9428-a58295bbfe29" />


당연하지 이눔아
다시 한 번 째려봐면 저기 DB 비번이 나 좀 보세요 하고 적혀져 있다. 저걸 깃헙에 올린다?걍 ㅋㅋ..ㅋㅋ...ㅋ..ㅋㅋ킄!!크큭..

이렇게 ./gitignore 수정해주고,

git add .gitignore -> git commit -m "쌸라쌸라" -> git push origin main

먼저 깃헙으로 보내드려야 한다.
그럼 끝~


# ResponseEntity

먼저 Controller의 코드를 보자

```
@GetMapping("/findType") 
    public ResponseEntity<List<TodoDto>> findBytype(@RequestParam String type) {
        List<TodoDto> responseValue = todoService.getTodoDtos(type);
        return new ResponseEntity<>(responseValue, HttpStatus.OK);
    }
```

흥미로운 부분이다.
ResponseEntity는 HTTP 상태 코드, 응답 바디, 헤더를 직접 제어할 수 있게 해준다.

그냥 List<TodoDto>만 리턴하면 서버가 클라이언트한테

"어... 그냥 데이터나 받으셈" 하고 던져주는 수준.

근데 ResponseEntity를 쓰면:

"성공했으니까 200 OK 줄게"

"엥엥 너 요청한 거 없거든? 204 No Content다 이눔아"

"뭔가 잘못 보냈다? 400 Bad Request다 이눔아"

이렇게 상태코드까지 같이 줘서 대화가 더 'REST스럽게' 된다고 할 수 있다.

그냥 List<TodoDto>로 return하면 그냥 시키는 일만 하는 알바생.

ResponseEntity<List<TodoDto>>로 return하면, 센스있게 일하는 야물딱진 알바생 같은 너낌...?

응응...
아 그리고 뭔가 과제하면서 느낀게 확실히 수업으로 듣는 것보다 실제로 다양한 API 써보고 서버까지 돌려보고 DB까지 다뤄보니 왠지 수준높아진 이 기분. 나쁘지 않았다.


# @Transactional
코드 다 짜고 Postman으로 실행하고 있는데,,,,아니나 다를까 수정이 안 먹히는 거다..DB를 확인해보니 DB도 변경이 안 되어있었다.

에러메시지 뜨는 것도 아니고 수정 완료 >< 라고 외치고 있지만 그럼 뭐하나 수정이 안 먹혔는데.

그래서 update 관련 함수를 찾아보는데 문제점이 안 보이길래 우리의 지선생에게 자문을 구해봤다.

<img width="400" alt="스크린샷 2025-04-12 오전 2 04 13" src="https://github.com/user-attachments/assets/ff607aab-3a2c-4f2b-b677-3bca1e55057a" />

@Transactional 어노테이션을 깜빡한 것이었다.

JPA는 트랜잭션 안에서 엔티티의 필드가 바뀐 걸 감지하고,
트랜잭션이 끝날 때 자동으로 UPDATE SQL을 날린다.

#  @Column, @Id, @GeneratedValue

프로젝트 시작할 때 나는 DB 먼저 연결해야겠다 생각했다. 세미나 때 비번 잠깐 잊어먹음 이슈로 어떻게 DB를 연결했었는지 기억을 소실한 것이다.

그래서 Spring 프로젝트 DB 연결을 찾아보다가....

@Entity class의 변수들에 @Column이라는 어노테이션만 붙여주면 자동으로 DB table(table 이름 = entity이름)이 생성된다는 것이다.

이거까지 Spring이 해준다니..

<img width="200" alt="스크린샷 2025-04-12 오전 2 14 28" src="https://github.com/user-attachments/assets/b3a4ea90-684d-4c9e-890f-812d1473b068" />

@Id는 이 필드가 테이블의 '기본 키'다!!!라고 박제하는 것인데,
JPA에서 이 엔티티의 기본 키(id)를 어떻게 자동 생성할지 정하는 설정 어노테이션이 바로 @GeneratedValue이다.

<img width="450" alt="스크린샷 2025-04-12 오전 2 26 18" src="https://github.com/user-attachments/assets/5f3f7238-5c36-4211-b3c0-8af12142c68d" />

taskId에 @Id를 달아줬고, Id 생성방식은 GenerationType.IDENTITY로 한다.

GenerationType.IDENTITY는, DB에서 자동 증가하는 숫자 (auto_increment)처럼, 이 id 필드 값을 내가 안 넣어도 DB가 알아서 넣어주게 한다.



코드 왠지 보기가 싫고 시작하기도 귀찮고 오늘 할 수 있으면 내일도 할 수 있다 마인드로 미루고미루고미루고미루고또미루고미뤄서 여기까지 왔지만 생각보다 수월하게 DB도 연결되고 자잘한 오류도 어렵지 않게 해결되어서 생각보다 재밌게 과제를 했다.

근데 중간에 git push -force였나 강제 덮어쓰기를 했는데 이거 때문인지 쓰던 리드미가 다 날라가고 히스토리에도 안 남아서 진심..

<img width="350" alt="스크린샷 2025-04-12 오전 2 33 58" src="https://github.com/user-attachments/assets/aa44d8e3-b57e-490b-9810-af8ff03c7fc5" />

다시 쓰기 짱 귀찮았는데 쓰다보니 좀 뿌듯하지만 걍 솔직히 졸리고 빨리 자고 싶다. 자고 일어나면 세미나를 가야 한다.


..일단 자.


