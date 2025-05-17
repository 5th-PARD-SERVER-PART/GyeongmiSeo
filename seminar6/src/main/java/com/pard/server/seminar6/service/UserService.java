package com.pard.server.seminar6.service;

import com.pard.server.seminar6.dto.UserReqDto;
import com.pard.server.seminar6.dto.UserResDto;
import com.pard.server.seminar6.entity.User;
import com.pard.server.seminar6.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public void createUser(UserReqDto.UserCreateReq req){
        User u = User.builder()
                .name(req.getName())
                .age(req.getAge())
                .part(req.getPart())
                .build();
        userRepo.save(u);
    }

    // get
    public UserResDto.ReadUser readUser(int id){
        Optional<User> u = userRepo.findById(id);
        User user = u.get();
        UserResDto.ReadUser ret = UserResDto.ReadUser.from(user);
        return ret;
    }

    public List<UserResDto.ReadUser> findAll() {
        List<User> users = userRepo.findAll();
        List<UserResDto.ReadUser> dtos = users.stream().map(
                user -> UserResDto.ReadUser.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .age(user.getAge())
                        .part(user.getPart())
                        .build()).toList();
        return dtos;
    }

    public List<UserResDto.ReadUser> findByPart(String part){
        List<User> users  = userRepo.findByPart(part);
        List<UserResDto.ReadUser> dtos = users.stream().map(
                user -> UserResDto.ReadUser.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .age(user.getAge())
                        .part(user.getPart())
                        .build()).toList();
        return dtos;
    }


    // update

    public void updateById(int userId, UserReqDto.UserUpdateReq req){
        User user = userRepo.findById(userId).orElseThrow();

        user.updateUser(req.getName(), req.getAge(), req.getPart());
        userRepo.save(user);
    }

    public void delete(int userId){
        User user = userRepo.findById(userId).orElseThrow(IllegalAccessError::new);
        userRepo.delete(user);
    }
}
