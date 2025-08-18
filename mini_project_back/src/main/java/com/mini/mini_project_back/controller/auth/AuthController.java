package com.mini.mini_project_back.controller.auth;

import com.mini.mini_project_back.common.constants.ApiMappingPattern;
import com.mini.mini_project_back.dto.ResponseDto;
import com.mini.mini_project_back.service.auth.AuthService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiMappingPattern.AUTH_API)
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/logout")
    public ResponseEntity<ResponseDto<Void>> logout(HttpServletResponse response) {
        ResponseDto<Void> responseDto = authService.logout(response);
        return ResponseDto.toResponseEntity(HttpStatus.OK, responseDto);
    }
}
