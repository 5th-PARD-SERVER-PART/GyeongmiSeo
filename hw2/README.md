# DTO...너 뭐 돼?

---

<img width="623" alt="스크린샷 2025-04-04 오후 10 46 53" src="https://github.com/user-attachments/assets/e05ebda1-e753-4651-86da-42e56add7f64"  width="200" height="400"/>

<위의 처리 과정 쌸라쌸라 해봄>

Controller는 맨 앞, 전방에서 URL 요청을 받는다.

해당 요청을 수행하기 위해  -> Service 함수 <- 를 먼저 거침.

<img width="878" alt="스크린샷 2025-04-04 오후 11 14 40" src="https://github.com/user-attachments/assets/e9815648-39de-4f6b-a8a7-a50b255ca6fe"  width="200" height="400"/>


아직은 연습단계라 지금 hw2의 코드에선 그냥 Repository 함수 호출 후 결과값 반환 & 요청처리 뿐이지만,

나중에 프로그램 규모가 커지고 더욱 안정적인 프로그램을 위해선 

1. 입력값의 유효성 검사
2. 예외처리 등등...
   
정말 Service라는 명성에 맞게 로직을 처리하는데에 도움을 주는 역할을 한다.

뿐만 아니라 실제 Controller가 시킨 일을 하기 위해 Repository라는 entity에 직접 접근가능한 친구를 호출해서 DTO(entity 복제본) 형태로 값을 주고 받게 됨.

Repository는 List, Map 형식으로 실제 프로그램에서 쓰이는 Entity값을 관리하고 있음

후.... 해치웠나?
