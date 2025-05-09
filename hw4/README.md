# 하하하

일단은...앞으론 미리미리 하겠다고 으름장을 놓았던 과거의 나에게 미안하다. 안 미안해서 미안해

코드 짜면서 분명 다음에 까먹지 않게 리드미도 아주 기깔나게 잘 써야지 생각했던 몇시간 전 나에게도 미안하다. 안 미안 아니 미안

졸리니깐 장난끼 빼고 본론부터 들어간다.

---

# 먼저 Entity를 본다.

<img width="548" alt="스크린샷 2025-05-03 오전 3 46 23" src="https://github.com/user-attachments/assets/51212cfc-e059-4e86-aa7a-60933363bd73" />

id(PK), title, content, 그리고 User의 아이디(user_id)를 FK로 갖는다.

User의 id를 외래키(FK)로 갖는다는 말은 즉슨, Post쪽에서 User의 data를 맘껏 남용하겠다는 이야기다.

ManyToOne(Post가 Many, User는 One) -> User 한 명은 여러개의 Post를 가질 수 있다.

cascade와 orphanremoval의 차이가 처음엔 너무 헷갈렸는데,

- cascade : 부모가 삭제되면, 그 삭제라는 행위?가 자식까지 흘러간다. -> 즉 자식까지 다 삭제된다 ㄷㄷ. 한 줄기 폭포수 같이 흐트러짐 없이.
- orphanremoval : cascade의 설정 옵션이다. 꼭 부모가 삭제되는 이슈가 없더라도, 부모와 자식의 관계가 끊기면, 그 자식(이제는 orphan이 된..)들을 싹 다 밀어버린다(삭제)..자비없는 그들의 세계

  <img width="150" alt="스크린샷 2025-05-03 오전 4 00 22" src="https://github.com/user-attachments/assets/794486be-7b68-4974-a60e-a7471dc4a1b7" />


---

#Controller

구현하고 싶은 '기능'은 총 4개.
1. new post(게시물) 생성하기 : createPost (POST)
2. 특정 작성자가 쓴 post 조회하기 : readByUserId(GET)
   (작성자마다 post는 여러개를 가질 수 있으니 return타입은 List.)
3. 이미 작성된 게시물 update(수정) : update (PATCH)
4. 꼴보기 싫은 게시물 delete(삭제) : delete (DELETE)

---

# 내 골을 아프게 한 Service & DTO

## createPost (new post 받아서 저장)
<img width="600" alt="스크린샷 2025-05-03 오전 4 02 55" src="https://github.com/user-attachments/assets/b84e0209-4f07-400f-9068-8ae05ee685a0" />

먼저 createPost는 클라이언트에게 받은 userId로 해당 user를 찾는다 : userRepo.findById(userId)

그리고 받은 body의 내용(PostCreateReqDto)으로 Post 객체 생성헤 준다. : Post post = new Post(null, req.getTitle(), req.getContent(), user)

그러고 난 후 DB에 소중하게 보관해준다. : postRepo.save(post)


## findByUserId (userId로 특정 user가 쓴 pos를 모두 List로 돌려주기)

<img width="600" alt="스크린샷 2025-05-03 오전 4 10 28" src="https://github.com/user-attachments/assets/8ae7d227-6bab-4be5-8302-22cdb3b8e146" />

코드가 길어보여도 별 거 없음 ㅋㅋ 

userId로 user가 쓴 post 다 찾아내서 List<PostReadResDto>로 만든 다음 return 때려주면 끝이다.

당연히 반환타입은 reponse용 dto이다. 

이 외에는 항상 했던 update, delete인데 이건 우리의 빛, JPA로 extend된 나의 작고 소중한 repo가 다 해주므로 패스. 절대 피곤해서 넘어가고 그런 거 절대 맞음.

---

이제서야 dto 분리 필요성을 알게된 나..

<img width="150" alt="스크린샷 2025-05-03 오전 4 16 58" src="https://github.com/user-attachments/assets/8a783633-da16-4a6a-a494-45cade0f1716" />

요즘 느끼는 거지만 2-3주간 잠을 제대로 못 잤더니 점점 인성 trash 되어간다. 잠은 정말 중요하다. 그냥 그렇다고
