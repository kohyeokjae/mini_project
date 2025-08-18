package com.mini.mini_project_back.service.user;

import com.mini.mini_project_back.dto.ResponseDto;
import com.mini.mini_project_back.dto.user.UserInfoResponseDto;
import com.mini.mini_project_back.security.UserPrincipal;

public interface UserService {
    ResponseDto<UserInfoResponseDto> userSearch(UserPrincipal userPrincipal);
}
