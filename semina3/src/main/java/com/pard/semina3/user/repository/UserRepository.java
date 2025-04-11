package com.pard.semina3.user.repository;

import com.pard.semina3.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> { // crud 기능 알아서 해줌
    public User findByEmail(String email); // 따로 구현하지 않아도 JPA가 알아서 해줌 ㅋㅋ

}
