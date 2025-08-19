package com.mini.mini_project_back.service.book;

import com.mini.mini_project_back.common.constants.ResponseCode;
import com.mini.mini_project_back.common.constants.ResponseMessageKorean;
import com.mini.mini_project_back.common.utils.DateUtils;
import com.mini.mini_project_back.dto.ResponseDto;
import com.mini.mini_project_back.dto.book.BookListResponseDto;
import com.mini.mini_project_back.entity.Book;
import com.mini.mini_project_back.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public ResponseDto<List<BookListResponseDto>> getAllBooks() {
        List<Book> books = null;
        List<BookListResponseDto> responseDtos = null;

        books = bookRepository.findAll();

        responseDtos = books.stream().map(book -> BookListResponseDto.builder()
                .isbn(book.getIsbn())
                .coverUrl(book.getCoverUrl())
                .bookTitle(book.getBookTitle())
                .categoryName(book.getCategoryId().getCategoryName())
                .authorName(book.getAuthorId().getAuthorName())
                .publisherName(book.getPublisherId().getPublisherName())
                .bookPrice(book.getBookPrice())
                .description(book.getDescription())
                .publishedDate(book.getPublishedDate().toLocalDate())
                .build())
            .collect(Collectors.toList());

        return ResponseDto.success(ResponseCode.SUCCESS, ResponseMessageKorean.SUCCESS, responseDtos);
    }
}
