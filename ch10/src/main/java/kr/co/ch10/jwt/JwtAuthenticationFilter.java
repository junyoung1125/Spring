package kr.co.ch10.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;

    private final String AUTHORIZATION_HEADER = "Authorization";
    private final String TokenPrefix = "Bearer ";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //토큰 추출
       String header= request.getHeader(AUTHORIZATION_HEADER);
       log.info("header:{}",header);
       if(header == null || !header.startsWith(AUTHORIZATION_HEADER)) {

           //다음 필터로 넘어가기(컨트롤러(DispatcherServlet)로 들어가기)
           filterChain.doFilter(request, response);
           return;
       }


       String token= header.substring(TokenPrefix.length());
       log.info("JWT Token: {}", token);

       //토큰 검사
        try {
            jwtProvider.validateToken(token);

            //토큰 검사 성공하면 시큐리티 인증처리
            Authentication authentication= jwtProvider.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);

        } catch (Exception e) {
            //토큰 검사 실패
            log.error("error validating token", e);
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
        }
        filterChain.doFilter(request, response);

    }
}

