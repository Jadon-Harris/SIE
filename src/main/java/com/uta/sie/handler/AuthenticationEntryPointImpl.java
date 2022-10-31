package com.uta.sie.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.uta.sie.common.ResponseResult;
import com.uta.sie.utils.WebUtils;

/**
 * @author Jadon
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ResponseResult<String> responseResult = new ResponseResult<>(HttpStatus.UNAUTHORIZED.value(), "user authentication failed");

        final String json = JSON.toJSONString(responseResult);
        WebUtils.renderString(response, json);
    }
}
