package com.mini.mini_project_back.security;

import com.mini.mini_project_back.entity.Customer;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPrincipal implements UserDetails, OAuth2User {

    private Long userId;
    private String email;
    private String name;
    private String phoneNumber;
    private Collection<? extends GrantedAuthority> authorities;
    @Setter
    private Map<String, Object> attributes;

    public UserPrincipal(Long userId, String email, String name, String phoneNumber, Collection<? extends GrantedAuthority> authorities) {
        this.userId = userId;
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.authorities = authorities;
    }

    public static UserPrincipal create(Customer user, Map<String, Object> attributes) {
        UserPrincipal principal = new UserPrincipal(
            user.getUserId(),
            user.getEmail(),
            user.getName(),
            user.getPhoneNumber(),
            java.util.Collections.singleton(() -> "ROLE_USER")
        );
        principal.setAttributes(attributes);
        return principal;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
