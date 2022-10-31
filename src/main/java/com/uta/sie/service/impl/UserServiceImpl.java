package com.uta.sie.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uta.sie.common.ResponseResult;
import com.uta.sie.entity.User;
import com.uta.sie.entity.dto.LoginUser;
import com.uta.sie.mapper.UserMapper;
import com.uta.sie.service.UserService;
import com.uta.sie.utils.JwtUtils;
import com.uta.sie.utils.RedisCache;

import lombok.AllArgsConstructor;

/**
 * @author Jadon
 */
@Service
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    private final AuthenticationManager authenticationManager;
    private final RedisCache redisCache;

    private final UserMapper userMapper;

    @Override
    public ResponseResult<Map<String, String>> login(User user) {
        final Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword()));

        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("username or password error.");
        }

        final LoginUser loginUser = (LoginUser) authenticate.getPrincipal();

        final String userId = loginUser.getUser().getId().toString();

        final String jwt = JwtUtils.createJWT(userId);

        Map<String, String> map = new HashMap<>();
        map.put("token", jwt);

        redisCache.setCacheObject("login:" + userId, loginUser);

        return new ResponseResult<>(200, "login success", map);
    }

    @Override
    public ResponseResult<String> logout() {
        final UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        final LoginUser loginUser = (LoginUser) authentication.getPrincipal();

        final String userId = loginUser.getUser().getId().toString();

        redisCache.deleteObject("login:" + userId);

        return new ResponseResult<>(200, "logout success.");
    }

    @Override
    public ResponseResult<User> signUp(User user) {
        final LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(!Objects.isNull(user.getName()), User::getName, user.getName());

        User userRes = userMapper.selectOne(userLambdaQueryWrapper);

        if (Objects.isNull(userRes)) {
            final User userToSave = new User();
            BeanUtils.copyProperties(user, userToSave, "password", "answer");
            userToSave.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            userToSave.setAnswer(new BCryptPasswordEncoder().encode(user.getAnswer()));
            userMapper.insert(userToSave);
            return new ResponseResult<>(HttpStatus.OK.value(), "sign up success.", userToSave);
        } else {
            return new ResponseResult<>(HttpStatus.UNAUTHORIZED.value(), "Username already exists.", null);
        }
    }

    @Override
    public ResponseResult<User> forgetPassword(User user) {
        final LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(!Objects.isNull(user.getName()), User::getName, user.getName());
        final User userRes = userMapper.selectOne(userLambdaQueryWrapper);
        final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (userRes.getQuestion().equals(user.getQuestion()) && bCryptPasswordEncoder.matches(user.getAnswer(), userRes.getAnswer())) {
            userRes.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userMapper.updateById(userRes);
            return new ResponseResult<>(HttpStatus.OK.value(), "password has been updated", userRes);
        } else {
            return new ResponseResult<>(400, "verification failed", null);
        }
    }


}
