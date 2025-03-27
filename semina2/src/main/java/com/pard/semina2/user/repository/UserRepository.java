package com.pard.semina2.user.repository;

import com.pard.semina2.user.dto.UserDto;
import com.pard.semina2.user.entity.User;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class UserRepository {
    private static final Map<Long, User> handong = new HashMap<>();
    public void save(UserDto userDto) {
        User user = User.builder()
                .studentId(userDto.getStudentId())
                .studentName(userDto.getStudentName())
                .build();
        handong.put(userDto.getStudentId(), user);
    }

    public UserDto findById(Long studentId) {
        User user = handong.get(studentId);

        return UserDto.builder()
                .studentId(user.getStudentId())
                .studentName(user.getStudentName())
                .build();
    }

    public void updateById(Long studentId, UserDto userDto) {
        User user = handong.get(studentId);

        user.setStudentId(userDto.getStudentId());
        user.setStudentName(userDto.getStudentName());
    }

    public void delete(Long studentId) {
        handong.remove(studentId);
    }

    public List<UserDto> findAll() {
        return handong.values().stream() // handong의 value들을 stream,즉 컨베이어벨트 위에 올려서, user값을 DTO로 변환(클래스 간 값을 주고 받을 때는 무조건 DTO로 변환해야 하기 때문에)
                .map(user -> UserDto.builder()
                        .studentId(user.getStudentId())
                        .studentName(user.getStudentName())
                        .build()).toList();
    }

}
