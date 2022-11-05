package com.uta.sie.service;

import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;
import com.uta.sie.common.ResponseResult;
import com.uta.sie.entity.User;

/**
 * @author Jadon
 */
public interface UserService extends IService<User> {
    ResponseResult<Map<String,String>> login(User user);

    ResponseResult<String> logout();

    ResponseResult<User> signUp(User user);

    ResponseResult<User> forgetPassword(User user);

    ResponseResult<User> getUserInfo(String userId);
}
