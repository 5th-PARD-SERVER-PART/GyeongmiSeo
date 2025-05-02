package com.pard.server.seminar4.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pard.server.seminar4.book.dto.BookResponse;
import com.pard.server.seminar4.book.entity.Book;
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

    public static class UserRequest {
        @Getter
        @Builder
        @NoArgsConstructor @AllArgsConstructor
        public static class UserReadRequest {
            private Long id;
            private String name;
            private List<Book> books;

            public static UserReadRequest from(User u) {
                return new UserReadRequest(u.getId(), u.getName(), u.getBook());
            }
        }

        @Getter
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @NoArgsConstructor @AllArgsConstructor
        public static class UserCreateRequest {
            private String name;
            private List<Book> book;
        }
    }
}
