package com.mini.mini_project_back.service.auth;

import com.mini.mini_project_back.dto.ResponseDto;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthService {
    ResponseDto<Void> logout(HttpServletResponse response);
}
