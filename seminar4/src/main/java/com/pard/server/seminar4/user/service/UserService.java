package com.pard.server.seminar4.user.service;

import com.pard.server.seminar4.user.dto.UserRequest;
import com.pard.server.seminar4.user.dto.UserResponse;
import com.pard.server.seminar4.user.entity.User;
import com.pard.server.seminar4.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class UserService {
    private final UserRepository userRepo;

    public UserResponse.ReadUser readUser(Long id ) {
        Optional<User> u = userRepo.findById(id);
        User user = u.get();
        UserResponse.ReadUser ret = UserResponse.ReadUser.from(user);
        return ret;
    }

    public void createUser(UserRequest.UserCreateRequest req) {
        User u = new User(null, req.getName(), req.getBook(), null);
        userRepo.save(u);
    }

    public void deleteUser(Long userId) {
        User user = userRepo.findById(userId).orElseThrow(IllegalAccessError::new);
        userRepo.delete(user);

    }


}

