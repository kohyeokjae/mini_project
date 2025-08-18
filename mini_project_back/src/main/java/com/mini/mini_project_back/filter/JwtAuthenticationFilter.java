package com.mini.mini_project_back.filter;

import com.mini.mini_project_back.entity.User;
import com.mini.mini_project_back.provider.JwtTokenProvider;
import com.mini.mini_project_back.repository.UserRepository;
import com.mini.mini_project_back.security.UserPrincipal;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String authorizationHeader = request.getHeader("Authorization");
            String token = (authorizationHeader != null && authorizationHeader.startsWith("Bearer "))
                ? jwtTokenProvider.removeBearer(authorizationHeader) : null;

            if (token == null && request.getCookies() != null) {
                for (Cookie cookie : request.getCookies()) {
                    if ("accessToken".equals(cookie.getName())) {
                        token = cookie.getValue();
                        break;
                    }
                }
            }

            if (token != null && jwtTokenProvider.validateToken(token)) {
                String email = jwtTokenProvider.getEmailFromToken(token);
                User user = userRepository.findByEmail(email).
                    orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));
                UserPrincipal userPrincipal = UserPrincipal.builder()
                    .userId(user.getUserId())
                    .email(email)
                    .name(user.getName())
                    .authorities(Collections.singleton(user::getRole))
                    .build();

                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userPrincipal, null, userPrincipal.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }

            filterChain.doFilter(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}