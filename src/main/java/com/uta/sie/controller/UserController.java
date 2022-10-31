package com.uta.sie.controller;

import java.util.Map;
import java.util.Objects;

import org.apache.ibatis.annotations.Update;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.uta.sie.common.ResponseResult;
import com.uta.sie.entity.User;
import com.uta.sie.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Jadon
 */
@RequestMapping("/user")
@RestController
@AllArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @PostMapping("/login")
    public ResponseResult<Map<String, String>> login(@RequestBody User user) {
        return userService.login(user);
    }

    @PostMapping("/logout")
    public ResponseResult<String> logout() {
        return userService.logout();
    }

    @PostMapping("/signUp")
    public ResponseResult<User> singUp(@RequestBody User user) {
        final LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(!Objects.isNull(user.getName()), User::getName, user.getName());
        final User userRes = userService.getOne(userLambdaQueryWrapper);
        if (Objects.isNull(userRes)) {
            final User userToSave = new User();
            BeanUtils.copyProperties(user, userToSave, "password", "answer");
            userToSave.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            userToSave.setAnswer(new BCryptPasswordEncoder().encode(user.getAnswer()));
            userService.save(userToSave);
            return new ResponseResult<>(HttpStatus.OK.value(), "sign up success.", userToSave);
        } else {
            return new ResponseResult<>(HttpStatus.UNAUTHORIZED.value(), "Username already exists.", null);
        }
    }

    @PutMapping("/forgetPassword")
    public ResponseResult<User> forgetPassword(@RequestBody User user) {
        final LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(!Objects.isNull(user.getName()), User::getName, user.getName());
        final User userRes = userService.getOne(userLambdaQueryWrapper);
        final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (userRes.getQuestion().equals(user.getQuestion()) && bCryptPasswordEncoder.matches(user.getAnswer(), userRes.getAnswer())) {
            userRes.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            final LambdaUpdateWrapper<User> userLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
            userService.update(userLambdaUpdateWrapper);
            return new ResponseResult<>(HttpStatus.OK.value(), "password has been updated", userRes);
        } else {
            return new ResponseResult<>(400, "verification failed", null);
        }
    }
}
