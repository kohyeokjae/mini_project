package com.mini.mini_project_back.dto.book;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookListResponseDto {
    private String isbn;
    private String bookTitle;
    private String categoryName;
    private String authorName;
    private String publisherName;
    private Long bookPrice;
    private LocalDate publishedDate;
    private String coverUrl;
    private String description;
}
