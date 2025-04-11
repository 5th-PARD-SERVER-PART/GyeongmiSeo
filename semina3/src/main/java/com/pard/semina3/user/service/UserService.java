package com.pard.semina3.user.service;

import com.pard.semina3.user.dto.UserDto;
import com.pard.semina3.user.entity.User;
import com.pard.semina3.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor

public class UserService {
    private final UserRepository userRepository;

    public void save(UserDto userDto) {
        User user = User.builder()
                .email(userDto.getEmail())
                .password(userDto.getPassward())
                .build();
        userRepository.save(user); // save라는 함수가 repository가 extention한 Jpa 뭐시기 인터페이스 클래스내부에 이미 구현되어 있음
    }

    public UserDto read(Long userId) {
        User user = userRepository.findById(userId).get();
        return UserDto.builder()
                .email(user.getEmail())
                .passward(user.getPassword())
                .build();
    }

    public Long getUserNum(String email) {
        User user = userRepository.findByEmail(email);
        return user.getUserId();
    }

    public List<UserDto> readAll() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = users.stream().map(
                user -> UserDto.builder()
                        .email(user.getEmail())
                        .passward(user.getPassword())
                        .build()).toList();
        return userDtos;
    }

    @Transactional // 함수가 도중에 멈추거나 오류가 생기면 아예 그냥 해당 함수 실행내역 초기화. 기면기고 아니면 아닌겨~ 그래서 최소단위로 함수를 쪼개서 transactional 어노테이션 사용
    public void update(Long userId, UserDto userDto) {
        User user = userRepository.findById(userId).get();
        // get 실행 중 생길 수 있는 에러 상황 처리하기(get에 노란 줄 사라지게) 예를 들어 ispresent
        user.updateEmail(userDto.getEmail());
        user.updatePassword(userDto.getPassward());
        userRepository.save(user);
    }

    // delete, fecth 는 내가 직접~
}
