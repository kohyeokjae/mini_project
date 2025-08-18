package com.mini.mini_project_back.controller.user;

import com.mini.mini_project_back.common.constants.ApiMappingPattern;
import com.mini.mini_project_back.dto.ResponseDto;
import com.mini.mini_project_back.dto.user.UserInfoResponseDto;
import com.mini.mini_project_back.security.UserPrincipal;
import com.mini.mini_project_back.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiMappingPattern.COMMON_API + "/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<ResponseDto<UserInfoResponseDto>> userSearch(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        ResponseDto<UserInfoResponseDto> responseDto = userService.userSearch(userPrincipal);
        return ResponseDto.toResponseEntity(HttpStatus.OK, responseDto);
    }
}
