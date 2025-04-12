package com.pard.server.seminar4.book.dto;

import com.pard.server.seminar4.book.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class BookResponse {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor

    public static class BookReadResponse {
        private Long bookId;
        private String title;

        public static List<BookReadResponse> bookToDto(List<Book> books) {
            List<BookReadResponse> ret = new ArrayList<>();
            for(Book book : books) {
                BookReadResponse b =
                        new BookReadResponse(book.getId(), book.getTitle());
                ret.add(b);
            }
            return ret;
        }
    }
}

