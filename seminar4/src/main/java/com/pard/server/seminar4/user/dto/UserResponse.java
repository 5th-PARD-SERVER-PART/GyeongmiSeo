package com.pard.server.seminar4.user.dto;

import com.pard.server.seminar4.book.dto.BookResponse;
import com.pard.server.seminar4.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class UserResponse {

    @Getter
    @Builder
    @NoArgsConstructor @AllArgsConstructor

    public static class ReadUser {
        private String name;
        private List<BookResponse.BookReadResponse> books;

        public static ReadUser from(User user) {
            return new ReadUser(user.getName(),
                    BookResponse.BookReadResponse.bookToDto(
                            user.getBook()));

        }

        public static ReadUser of(User user) {
            return ReadUser.builder()
                    .name(user.getName())
                    .books(BookResponse.BookReadResponse.bookToDto(
                            user.getBook()))
                    .build();
        }

    }

}
