package com.uta.sie;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.uta.sie.entity.dto.LoginUser;
import com.uta.sie.utils.JwtUtils;
import com.uta.sie.utils.RedisCache;

import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;

/**
 * @author Jadon
 */
@Component
@AllArgsConstructor
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private final RedisCache redisCache;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("token");

        if (!StringUtils.hasText(token)){
            filterChain.doFilter(request,response);
            return;
        }

        String userId;
        try {
            final Claims claims = JwtUtils.parseJWT(token);
            userId = claims.getSubject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("token invalid.");
        }

        String redisKey = "login:"+userId;
        final LoginUser loginUser = redisCache.getCacheObject(redisKey);

        if (Objects.isNull(loginUser)){
            throw new RuntimeException("user not logged in.");
        }

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginUser,null,null);

        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        filterChain.doFilter(request,response);
    }
}
