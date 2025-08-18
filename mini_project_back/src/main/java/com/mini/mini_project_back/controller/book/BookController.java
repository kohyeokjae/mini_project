package com.mini.mini_project_back.controller.book;

import com.mini.mini_project_back.common.constants.ApiMappingPattern;
import com.mini.mini_project_back.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiMappingPattern.COMMON_API+ "/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<ResponseDto<BookListResponseDto>> getAllBooks() {
        ResponseDto<BookListResponseDto> responseDto = bookService.getAllBooks();
        return ResponseDto.toResponseEntity(HttpStatus.OK, responseDto);
    }
}
