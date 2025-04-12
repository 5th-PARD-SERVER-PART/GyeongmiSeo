package com.pard.server.seminar4.user.repository;

import com.pard.server.seminar4.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {


}

