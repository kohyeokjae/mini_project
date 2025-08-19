package com.mini.mini_project_back.service.oauth;

import com.mini.mini_project_back.dto.info.KakaoUserInfo;
import com.mini.mini_project_back.dto.info.NaverUserInfo;
import com.mini.mini_project_back.dto.info.OAuth2UserInfo;
import com.mini.mini_project_back.entity.Customer;
import com.mini.mini_project_back.repository.UserRepository;
import com.mini.mini_project_back.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        OAuth2UserInfo userInfo;

        if ("kakao".equals(registrationId)) {
            userInfo = new KakaoUserInfo(oAuth2User.getAttributes());
        } else if ("naver".equals(registrationId)) {
            userInfo = new NaverUserInfo((Map<String, Object>) oAuth2User.getAttributes().get("response"));
        } else {
            throw new OAuth2AuthenticationException("지원하지 않는 OAuth2 공급자입니다: " + registrationId);
        }

        Optional<Customer> userOptional = userRepository.findByEmail(userInfo.getEmail());
        Customer user;

        if (userOptional.isPresent()) {
            user = userOptional.get();
        } else {
            user = Customer.builder()
                .email(userInfo.getEmail())
                .name(userInfo.getName())
                .phoneNumber(userInfo.getPhoneNumber())
                .provider(registrationId)
                .providerId(userInfo.getProviderId())
                .role("ROLE_USER")
                .build();
            userRepository.save(user);
        }

        return UserPrincipal.create(user, oAuth2User.getAttributes());
    }
}