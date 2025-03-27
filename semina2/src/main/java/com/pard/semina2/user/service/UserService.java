package com.pard.semina2.user.service;


import com.pard.semina2.user.dto.UserDto;
import com.pard.semina2.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // final 클래스 생성자
public class UserService {
    private final UserRepository userRepository; // 이것또한 바뀌면 위험하므로 final로 선언

    public void saveUser (UserDto userDto) {
        userRepository.save(userDto);
    }

    public UserDto findById(Long studentId) {
        return userRepository.findById(studentId);
    }

    public void updateById(Long studentId, UserDto userDto) {
        userRepository.updateById(studentId, userDto);
    }

    public void delete(Long studentId) {
        userRepository.delete(studentId);
    }

    public List<UserDto> findAll() {
        return userRepository.findAll();
    }
}
