package com.uta.sie.service.impl;

import java.util.Objects;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.uta.sie.entity.User;
import com.uta.sie.entity.dto.LoginUser;
import com.uta.sie.mapper.UserMapper;

import lombok.AllArgsConstructor;

/**
 * @author Jadon
 */
@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查询用户信息
        final LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getName,username);
        final User user = userMapper.selectOne(userLambdaQueryWrapper);

        if (Objects.isNull(user)){
            throw new RuntimeException("username or password wrong.");
        }

        // 返回封装好的UserDetails
        return new LoginUser(user);
    }
}
