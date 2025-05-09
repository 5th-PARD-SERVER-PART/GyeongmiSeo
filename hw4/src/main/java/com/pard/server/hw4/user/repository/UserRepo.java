package com.pard.server.hw4.user.repository;

import com.pard.server.hw4.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

}
