package com.mini.mini_project_back.service.user;

import com.mini.mini_project_back.common.constants.ResponseCode;
import com.mini.mini_project_back.common.constants.ResponseMessageKorean;
import com.mini.mini_project_back.dto.ResponseDto;
import com.mini.mini_project_back.dto.user.UserInfoResponseDto;
import com.mini.mini_project_back.security.UserPrincipal;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public ResponseDto<UserInfoResponseDto> userSearch(UserPrincipal userPrincipal) {
        if (userPrincipal == null) {
            return ResponseDto.fail(ResponseCode.FAIL, ResponseMessageKorean.FAILED);
        }

        UserInfoResponseDto responseDto = UserInfoResponseDto.builder()
            .id(userPrincipal.getUserId())
            .email(userPrincipal.getEmail())
            .name(userPrincipal.getName())
            .phoneNumber(userPrincipal.getPhoneNumber())
            .role(userPrincipal.getAuthorities().iterator().next().getAuthority())
            .build();

        return ResponseDto.success(ResponseCode.SUCCESS, ResponseMessageKorean.SUCCESS, responseDto);
    }
}
