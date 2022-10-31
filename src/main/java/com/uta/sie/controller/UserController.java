package com.uta.sie.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return userService.signUp(user);
    }

    @PutMapping("/forgetPassword")
    public ResponseResult<User> forgetPassword(@RequestBody User user) {
        return userService.forgetPassword(user);
    }
}
