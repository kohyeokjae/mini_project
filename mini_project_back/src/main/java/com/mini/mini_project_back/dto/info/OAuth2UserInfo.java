package com.mini.mini_project_back.dto.info;

import java.util.Map;

public interface OAuth2UserInfo {
    String getProviderId();
    String getEmail();
    String getName();
    String getPhoneNumber();
}