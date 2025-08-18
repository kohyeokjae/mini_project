package com.mini.mini_project_back.dto.user;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserInfoResponseDto {
    private Long id;
    private String name;
    private String email;
    private String role;
}
