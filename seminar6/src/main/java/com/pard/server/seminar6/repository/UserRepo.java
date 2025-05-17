package com.pard.server.seminar6.repository;

import com.pard.server.seminar6.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Integer> {
    public List<User> findByPart(String part);
}
