package com.mini.mini_project_back.service.book;

import com.mini.mini_project_back.dto.ResponseDto;
import com.mini.mini_project_back.dto.book.BookListResponseDto;

import java.util.List;

public interface BookService {
    ResponseDto<List<BookListResponseDto>> getAllBooks();
}
